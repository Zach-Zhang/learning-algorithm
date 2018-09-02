package com.zach.alogrithm.easy;

/**
 * 菲波列切数列,从第三项数开始,每一项等于前两项之和
 */
public class FibonacciNum {
    public static void main(String[] args) {
        System.out.println(findFibonacciNum(10));
    }

    public static int findFibonacciNum(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a;

    }
}
