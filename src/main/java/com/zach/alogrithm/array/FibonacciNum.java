package com.zach.alogrithm.array;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class FibonacciNum {

    public static void main(String[] args) {
        System.out.println(method(5));
    }

    public static int method(int N) {
        int a = 0;
        int b = 1;
        int c;
        if(N == 0)
            return a;
        if(N == 1)
            return b;

        while(N>1) {
            c= a+b;
            a = b;
            b= c;
            N = N-1;
        }
        return b;
    }
}
