package com.zach.second;

/**
 * @Description: 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数
 * 组中
 * @Author Zach
 * @Date 2022/4/12 8:24
 * Version :1.0
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean flag = findNumberIn2DArray(matrix, 21);
        System.out.println(flag);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int row = matrix.length;
        int column = matrix[0].length;
        //从最右上角开始
        int r = 0;
        int c = column - 1;
        while (r <= row - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
