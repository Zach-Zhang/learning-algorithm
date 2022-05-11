package com.zach.second;

/**
 * @Description:
 * @Author Zach
 * @Date 2022/4/16 20:22
 * Version :1.0
 */
public class Fibonacci {
    public static void main(String[] args) {

    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
