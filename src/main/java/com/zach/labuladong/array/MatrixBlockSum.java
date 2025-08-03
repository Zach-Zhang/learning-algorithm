package com.zach.labuladong.array;

import com.alibaba.fastjson2.JSON;

/**
 * Given an m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
 * * i - k <= r <= i + k,
 * * j - k <= c <= j + k, and
 * * (r, c) is a valid position in the matrix.
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * Example 2:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 */
public class MatrixBlockSum {
    private int[][] preSum;
    public MatrixBlockSum(int[][] mat){
        if(mat==null){
            return;
        }
        int row = mat.length;
        int col = mat[0].length;
        this.preSum = new int[mat.length+1][mat[0].length+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                //求（0，,0）到（i-1,j-1)这个区域内所有元素的和
                preSum[i][j] = preSum[i][j-1]+preSum[i-1][j]-preSum[i-1][j-1]+mat[i-1][j-1];
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum(mat);
        int[][] answer = matrixBlockSum.calcAnswer(mat, 2);
        System.out.println(JSON.toJSON(answer));

    }

    public int[][] calcAnswer(int[][]mat,int k){
        int row = mat.length;
        int col = mat[0].length;
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            //上边界
            int r1 = Math.max(0,i-k);
            //下边界
            int r2 = Math.min(row-1,i+k);
            for (int j = 0; j < col; j++) {
                //左边界
                int c1 = Math.max(0,j-k);
                //右边界
                int c2 = Math.min(col-1,j+k);
                //大矩形-上方矩形-左边矩形+重叠矩形
                answer[i][j] = preSum[r2+1][c2+1]-preSum[r1][c2+1]-preSum[r2+1][c1]+preSum[r1][c1];
            }
        }
        return answer;
    }
}
