package com.zach.frequency;

/**
 * @Description:从 1 到 n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 * @Author Zach
 * @Date 2021/4/13 11:08
 * Version :1.0
 */
public class CountOneNumber {
    public static void main(String[] args) {

    }

    public static int countOneNumber(int num) {
        int digit = 1;
        int res = 0;
        int high = num / 10;
        int cur = num % 10;
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
