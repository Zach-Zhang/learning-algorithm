package com.zach.frequency;

/**
 * @Classname Fibonacci
 * @Description: 求斐波那契数列的第 n 项，n <= 39;斐波那契数列数列从第三项开始,每一项的值
 * 等于前两项之和,0,1,1,2,3,5,8,13,21,34,55,89....
 * @Date 2020/7/20 22:48
 * @Author: Zach
 * @version: V1.0
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(methodOne(5));
        System.out.println(menthodSecond(5));
    }

    //根据数列定义,使用递归求解
    public static int methodOne(int n) {
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
    /*考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项
      从而将空间复杂度由 O(N) 降低为 O(1)。*/
    public static int menthodSecond(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 0, pre2 = 1;
        int fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
}
