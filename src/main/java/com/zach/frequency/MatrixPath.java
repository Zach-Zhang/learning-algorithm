package com.zach.frequency;

public class MatrixPath {
    //行
    private int rows;
    //列
    private int cols;
    //定义的是上下左右移动的坐标增量
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hashPath(char[] array, int rows, int cols, char[] str) {
        boolean flag = rows == 0 || cols == 0;
        if (flag) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtracking(matrix, str, marked, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int row, int col) {
        //当搜索路径的长度=输入字符串的长度时,表示已经找到,递归结束
        if (pathLen == str.length) {
            return true;
        }
        //没有找到的条件,行列已经搜索完了,仍然没有找到全部字符; 矩阵中出现字符中没有的元素,某行某列的元素重复了
        boolean flag = row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != str[pathLen] || marked[row][col];
        if (flag) {
            return false;
        }
        //标记已经走过的路径
        marked[row][col] = true;
        for (int[] n : next) {
            //向上下左右递归搜索
            if (backtracking(matrix, str, marked, pathLen + 1, row + n[0], col + n[1])) {
                return true;
            }
        }
        marked[row][col] = false;//搜索完一轮,没有找到之后,如需将原有的标记搜索的状态清除,即回溯,方便开始下一轮的搜索
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0, index = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[index++];
            }
        }
        return matrix;
    }
}
