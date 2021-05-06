package com.zach.frequency;

/**
 * @Description:数字序列中的某一位数字 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 * @Author Zach
 * @Date 2021/5/6 21:41
 * Version :1.0
 */
public class FindNthDigit {
    public static void main(String[] args) {
        int nthDigit = findNthDigit(20);
        System.out.println(nthDigit);
    }

    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        //1. 确定n所在的数字的位数digit
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        //2. 确定n所在的数字num
        long num = start + (n - 1) / digit;
        //确定n是num的第几位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
