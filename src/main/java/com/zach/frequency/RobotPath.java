package com.zach.frequency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个 m行和 n列的方格。一个机器人从坐标 (0,0)的格子开始移动，每一次只能向左右上下四个方向移动一
 * 格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为
 * 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class RobotPath {

    public static void main(String[] args) {
        CommonDFS commonDFS = new CommonDFS();
        OptimizeDFS optimizeDFS = new OptimizeDFS();
        OptimizeBFS optimizeBFS = new OptimizeBFS();
        int c1 = optimizeDFS.movingCount(10, 20, 18);
        int c2 = commonDFS.movingCount(18, 10, 20);
        int c3 = optimizeBFS.movingCount(10, 20, 18);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    //普通的DFS搜索算法
    public static class CommonDFS {
        //记录可达格数
        private int cnt = 0;
        private final int[][] next = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        private int rows;
        private int cols;
        private int threshold;
        private int[][] digitSum;

        /**
         * 使用深度优先搜索方法
         *
         * @param threshold
         * @param rows
         * @param cols
         * @return
         */
        public int movingCount(int threshold, int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.threshold = threshold;
            initDigitSum();
            boolean[][] marked = new boolean[rows][cols];
            dfs(marked, 0, 0);
            return cnt;
        }

        private void dfs(boolean[][] marked, int r, int c) {
            //行或者列越界或者已经访问过得格子则直接返回
            if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
                return;
            }
            marked[r][c] = true;
            //超出了限定值的格子也直接返回
            if (this.digitSum[r][c] > this.threshold) {
                return;
            }
            cnt++;
            //向左右上下移动一格
            for (int[] n : next) {
                dfs(marked, r + n[0], c + n[1]);
            }
        }

        private void initDigitSum() {
            //存储每个单元格的坐标的数位之和
            int[] digitSumOne = new int[(Math.max(rows, cols))];
            for (int i = 0; i < digitSumOne.length; i++) {

                int n = i;
                while (n > 0) {
                    //取得各个位数之后
                    digitSumOne[i] += n % 10;
                    //减少位数,如从三位数变成二位数,直到变成个数
                    n /= 10;
                }
            }
            this.digitSum = new int[rows][cols];
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    //求得行列的数位之和
                    this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
                }
            }
        }
    }

    /**
     * 深度优先搜索算法的优化:
     * 1. 数位之和的优化:
     * 由于机器人每次只能移动一格,故每次只需计算x到x±1的数位和增量,得到数位增量公式
     * 当(x+1)%10=0时: s(x+1)=s(x)-8,如19,20的数位和分别为10,2;
     * 当(x+1)%10!=0时,s(x+1)=s(x)+1,如1,2的数位和为1,2;
     * 故可总结的数位和公式:
     * (x + 1) % 10 != 0 ? s_x + 1 : s_x - 8
     * 2. 搜索方向的简化:
     * 根据上面的公式得知,数位每逢进位突变一次
     * 解的三角形结构：
     * 根据数位和特点，矩阵中 满足数位和的解 构成的几何形状形如多个 等腰直角三角形 ，每个三角形的直角顶点位于 0, 10, 20, ...0,10,20,... 等数位和突变的矩阵索引处 。
     * 三角形内的解虽然都满足数位和要求，但由于机器人每步只能走一个单元格，而三角形间不一定是连通的，因此机器人不一定能到达，称之为 不可达解 ；同理，可到达的解称为 可达解 （
     * <p>
     * 结论： 根据可达解的结构，易推出机器人可 仅通过向右和向下移动，访问所有可达解
     * 复杂度分析：
     * M,N 分别为矩阵行列大小。
     * <p>
     * 时间复杂度 O(MN) ： 最差情况下，机器人遍历矩阵所有单元格，此时时间复杂度为 O(MN)。
     * 空间复杂度 O(MN) ： 最差情况下，Set visited 内存储矩阵所有单元格的索引，使用 O(MN)的额外空间。
     */
    public static class OptimizeDFS {
        int m, n, k;
        boolean[][] visited;

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        private int dfs(int i, int j, int si, int sj) {
            //当行列索引越界 或 数位和超出目标值 k 或 当前元素已访问过 时，返回 0 ，代表不计入可达解。
            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            //向右或向下移动一格
            return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        }
    }

    /**
     * 广度优先遍历BFS
     * BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。DFS 是朝一个方向走到底，再回退，以此类推；BFS 则是按照“平推”的方式向前搜索。
     * BFS 实现： 通常利用队列实现广度优先遍历。
     * 算法解析：
     * 初始化： 将机器人初始点 (0, 0) 加入队列 queue ；
     * 迭代终止条件： queue 为空。代表已遍历完所有可达解。
     * 迭代工作：
     * 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
     * 判断是否跳过： 若 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，执行 continue 。
     * 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，代表此单元格 已被访问过 。
     * 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
     * 返回值： Set visited 的长度 len(visited) ，即可达解的数量。
     * 复杂度分析：
     * M, NM,N 分别为矩阵行列大小。
     * <p>
     * 时间复杂度 O(MN)O(MN) ： 最差情况下，机器人遍历矩阵所有单元格，此时时间复杂度为 O(MN)。
     * 空间复杂度 O(MN)O(MN) ： 最差情况下，Set visited 内存储矩阵所有单元格的索引，使用 O(MN)的额外空间。
     */
    public static class OptimizeBFS {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            int res = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 0, 0});
            while (queue.size() > 0) {
                int[] x = queue.poll();
                int i = x[0], j = x[1], si = x[2], sj = x[3];
                if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                res++;
                queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
                queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
            }
            return res++;
        }



    }
}
