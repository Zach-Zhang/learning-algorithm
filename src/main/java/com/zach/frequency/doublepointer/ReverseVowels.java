package com.zach.frequency.doublepointer;

/**
 * @Description: 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * @Author Zach
 * @Date 2022/2/20 8:51
 * Version :1.0
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String str = reverseVowels("hellO");
        String str2 = reverseVowels2("hellO");
        System.out.println(str);
        System.out.println(str2);
    }

    /**
     * 双指针
     * 使用两个指针 ii 和 jj 对字符串相向地进行遍历。
     *
     * @param srcStr
     * @return
     */
    public static String reverseVowels(String srcStr) {
        if (srcStr == null || srcStr.equals("")) {
            return srcStr;
        }
        int i = 0;
        char[] charArray = srcStr.toCharArray();
        int len = charArray.length - 1;
        int j = len;
        while (i < j) {
            while (i < len && !isVowels(charArray[i])) {
                ++i;
            }
            while (j > 0 && !isVowels(charArray[j])) {
                --j;
            }
            if (i < j) {
                swap(charArray, i, j);
                ++i;
                --j;
            }
        }
        return new String(charArray);
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    private static boolean isVowels(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public static String reverseVowels2(String srcStr) {
        if (srcStr == null || srcStr.equals("")) {
            return srcStr;
        }
        char[] res = new char[srcStr.length()];
        int i = 0;
        int j = srcStr.length() - 1;
        while (i < j) {
            char ci = srcStr.charAt(i);
            char cj = srcStr.charAt(j);
            if (!isVowels(ci)) {
                res[i++] = ci;
            } else if (!isVowels(cj)) {
                res[j--] = cj;
            } else {
                res[i++] = cj;
                res[j--] = ci;
            }
        }
        return new String(res);
    }
}
