package com.zach.frequency;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3
 * 一直到最大的 3 位数即(要考虑大数问题)
 * 999。
 *
 * 思路:
 * 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。
 * 例如当 n = 2时（数字范围 1 - 99 ），固定十位为 00 - 99 ，按顺序依次开启递归，固定个位 00 - 99 ，终止递归并添加数字字符串。
 *
 */
public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }

    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private static void print1ToMaxOfNDigits(char[] number, int digit) {
        //递归的边界就是就是n=digit,即打印到最后一位
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            //将int类型的数字转换成字符char
            number[digit] = (char) (i + '0');
            //递归处理,先固定高位的数字,向低位递归
            print1ToMaxOfNDigits(number, digit + 1);
        }

    }

    private static void printNumber(char[] number) {
        int index = 0;
        //去除高位的'0'
        while (index < number.length && number[index] == '0') {
            index++;
        }
         while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }
}
