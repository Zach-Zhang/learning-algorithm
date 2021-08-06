package com.zach.frequency;

/**
 * @Description:礼物的最大价值 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右
 * 或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * 1 10 3 8
 * 12 2 9 6
 * 5 7 4 11
 * 3 7 16 5
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 * @Author Zach
 * @Date 2021/7/4 8:12
 * Version :1.0
 */
public class FindMaxOfMap {
    public static void main(String[] args) {
         int[][] matrix = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 7, 11}, {3, 3, 16, 5}};
        //int[][] matrix = {{1, 2, 5}, {3, 2, 1}};
        int maxOfMap = findMaxOfMap(matrix);
        System.out.println(maxOfMap);
    }

    public static int findMaxOfMap(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                //i==0,j!=0,第一行的元素,只从从左边到达,grid[i][j]表示当前单元格的礼物价值
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    //i!=0,j==0,第一列的元素,只从从上边到达,grid[i][j]表示当前单元格的礼物价值
                    grid[i][j] += grid[i - 1][j];
                } else {
                    //可从左边或者上边到达
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
