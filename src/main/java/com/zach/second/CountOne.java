package com.zach.second;

/**
 * @Description: 二进制中 1 的个数
 * @Author Zach
 * @Date 2022/4/20 9:48
 * Version :1.0
 */
public class CountOne {
    public static void main(String[] args) {
        int count = countOne(11);
        System.out.println(count);
    }

    public static int countOne(int n) {
        int cn = 0;
        while (n != 0) {
            //该位运算去除 n 的位级表示中最低的那一位。
            n &= (n - 1);
            cn++;
        }
        return cn;
    }
}
