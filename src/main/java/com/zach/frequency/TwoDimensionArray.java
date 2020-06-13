package com.zach.frequency;

/**
 * @Classname TwoDimensionArray
 * @Description:
 * @Date 2020/6/13 10:57
 * @Author: Zach
 * @version: V1.0
 */
public class TwoDimensionArray {
    public static void main(String[] args) {
        int[][] A = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(method1(A,190));
    }

    public static boolean method1(int[][] A, int target) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return false;

        int row = A.length;
        int col = A[0].length;
        //从二维数组右上角开始,比它大的在下一行,比它小的在左边
        int r = 0, c = col - 1;
        while (r <= row - 1 && c >= 0) {
            if (target == A[r][c]) {
                return true;
            } else if (target < A[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
