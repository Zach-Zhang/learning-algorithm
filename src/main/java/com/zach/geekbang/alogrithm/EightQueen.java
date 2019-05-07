package com.zach.geekbang.alogrithm;

/**
 * @Auther: Zach
 * @Date: 2019/4/20 15:50
 * @Description: 八皇后问题
 * 我们有一个 8x8 的棋盘，
 * 希望往里放 8 个棋子（皇后）每个棋子所在的行、列、对角线都不能有另一个棋子
 */
public class EightQueen {
    public static void main(String[] args) {
        cal8queens(0);
    }

    //下标表示行,值表示存储在列上的queen
    static int[] result = new int[8];

    public static void cal8queens(int row) {
        //每行都排列好了,结束递归
        if (row == 8) {
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            //放法是否符合要求
            if (isOk(row, column)) {
                result[row] = column;
                //检查下一行
                cal8queens(row + 1);
            }
        }

    }

    private static boolean isOk(int row, int column) {

        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            //第i行上有column列有棋子
            if (result[i] == column)
                return false;
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }

            if (rightUp < 8 && result[i] == rightUp) {
                return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if(result[row]==column)
                    System.out.print("Q: ");
                else
                    System.out.print("*");

            }
            System.out.println();
        }
        System.out.println();
    }
}
