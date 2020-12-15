package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/12/15 11:01
 * Description :顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Version :1.0
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[] result = printMatrixMethod2(matrix);
        int[] result = printMatrixMethod1(matrix);
        System.out.println(result);
    }

    /**
     * @return int[]
     * @Description:设定矩阵的“左、上、右、下”四个边界，模拟以上矩阵遍历顺序 打印方向    1. 根据边界打印	2. 边界向内收缩	3. 是否打印完毕
     * 从左向右	左边界l ，右边界 r	上边界 t 加 1	是否 t > b
     * 从上向下	上边界 t ，下边界b	右边界 r 减 1	是否 l > r
     * 从右向左	右边界 r ，左边界l	下边界 b 减 1	是否 t > b
     * 从下向上	下边界 b ，上边界t	左边界 l 加 1	是否 l > r
     * @Param [matrix]
     **/
    public static int[] printMatrixMethod1(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int button = matrix.length - 1;
        int[] res = new int[(right + 1) * (button + 1)];
        int index = 0;
        while (true) {
            //从左向右
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > button)
                break;
            //从上到下
            for (int i = top; i <= button; i++) {
                res[index++] = matrix[i][right];

            }
            if (left > --right) {
                break;
            }

            //从右向左
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[button][i];
            }
            if (top > --button) {
                break;
            }
            //从下到上
            for (int i = button; i >= top; i--) {
                res[index++] = matrix[i][left];

            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    /**
     * @return int[]
     * @Description: 模拟打印矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
     * @Date 11:32 2020/12/15
     * @Param [matrix]
     **/
    public static int[] printMatrixMethod2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] result = new int[total];
        int row = 0;
        int column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        for (int i = 0; i < total; i++) {
            result[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directIndex][0];
            int nextColumn = column + directions[directIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directIndex = (directIndex + 1) % 4;
            }
            row += directions[directIndex][0];
            column += directions[directIndex][1];
        }
        return result;

    }


}
