package com.zach.frequency.doublepointer;

/**
 * @Description: 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Zach
 * @Date 2022/2/25 10:38
 * Version :1.0
 */
public class FindLongestWord {
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] dictionary = {"ale", "apple", "monkey", "pcplea"};
        String longestWord = findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }

    public static String findLongestWord(String s, String[] dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0;
            int j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
                if (i == t.length()) {
                    if (t.length() > res.length() || (t.length() == res.length() && res.compareTo(t) > 0)) {
                        res = t;
                    }
                }
            }
        }
        return res;
    }
}
