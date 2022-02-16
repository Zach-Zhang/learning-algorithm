package com.zach.frequency;

/**
 * @Description: 写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号
 * @Author Zach
 * @Date 2022/2/9 0:10
 * Version :1.0
 */
public class Add {
    public static void main(String[] args) {
        int sum = add2(3, 9);
        System.out.println(sum);
    }

    /**
     * 无进位的和 a^b
     * 有进位的和 a&b<<1
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        return b == 0 ? a : (add(a ^ b, (a & b) << 1));
    }

    /**
     * @return
     */
    public static int add2(int a, int b) {
        while (b != 0) {
            //进位
            int n = (a & b) << 1;
            //非进位
            a ^= b;
            b = n;
        }
        return a;
    }
}
