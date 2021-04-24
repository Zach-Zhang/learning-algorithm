package com.zach.frequency;

/**
 * @Description:数字序列中的某一位数字 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * @Author Zach
 * @Date 2021/4/15 16:04
 * Version :1.0
 */
public class FindNumInStr {
    public static void main(String[] args) {

    }

    public static int findNthDigit(int n) {
        //n所在数字的位数
        int digit = 1;
        //每digit位数的起始数字
        int start = 1;
        //数位的数量
        int count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit);
    }
}