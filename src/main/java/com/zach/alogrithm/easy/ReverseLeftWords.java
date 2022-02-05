package com.zach.alogrithm.easy;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @Description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * @Author Zach
 * @Date 2021/9/9 8:22
 * Version :1.0
 */
public class ReverseLeftWords {
    public static void main(String[] args) {

    }

    public static String reverseLeftWords(String sourceStr, int k) {
        if (StringUtils.isEmpty(sourceStr) || k <= 0 || k > sourceStr.length()) {
            return sourceStr;
        }
        int length = sourceStr.length();
        char[] chars = sourceStr.toCharArray();
        reverse(0, k - 1, chars);
        reverse(k, length - 1, chars);
        reverse(0, length - 1, chars);
        return new String(chars);
    }

    public static void reverse(int i, int j, char[] chars) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }
}
