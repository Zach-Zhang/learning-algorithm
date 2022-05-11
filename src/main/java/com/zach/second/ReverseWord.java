package com.zach.second;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 翻转单词顺序列
 * <p>
 * Input:
 * "I am a student."
 * Output:
 * "student. a am I"
 * <p>
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @Author Zach
 * @Date 2022/4/17 14:43
 * Version :1.0
 */
public class ReverseWord {
    public static void main(String[] args) {
        String source = "I am a student.";
        String s2 = " hello world!     ";
        String reverse = reverseWord(s2);
        System.out.println(reverse);
    }

    public static String reverseWord(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        //指向单词首字符
        int i = 0;
        //向右滑动
        int j = 0;
        int len = source.length();
        char[] chars = source.toCharArray();

        while (j <= len) {
            //j到达末尾或者遇到空格，先翻转单词
            if (j == len || chars[j] == ' ') {
                reverse(i, j - 1, chars);
                ////i指向空格右边的下一个单词的首字母
                i = j + 1;
            }
            //向右移动
            j++;
        }
        //此处的翻转，是一个轴对称的翻转，首位互换，第二位到倒数第二位，依次类推
        reverse(0, len - 1, chars);
        return new String(chars);
    }

    private static void reverse(int i, int j, char[] chars) {
        while (i < j) {
            swap(i++, j--, chars);
        }

    }

    private static void swap(int i, int j, char[] chars) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
