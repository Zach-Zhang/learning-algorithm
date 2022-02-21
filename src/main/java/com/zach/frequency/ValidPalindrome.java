package com.zach.frequency;

/**
 * @Description: 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * @Author Zach
 * @Date 2022/2/21 23:36
 * Version :1.0
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        boolean flag = validPalindrome("abccba");
        System.out.println(flag);
    }

    /**
     * 双指针解法，i从0,开始遍历，j从末尾开始遍历，当i上的字符!=j上的字符时，就可以删除一个字符
     * 再观察剩下的字符是否为回文字符串，剩下的字符[i+1,j)或者（i,j-1)，两者有一个为回文串都符合
     *
     * @param str
     * @return
     */
    public static boolean validPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
