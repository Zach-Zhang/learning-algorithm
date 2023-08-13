package com.zach.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 最长子序列
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 *
 * https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/description/
 * @Author Zach
 * @Date 2023-07-25 22:26
 * Version :1.0
 */
public class FindLongestWord {
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] dictionary = {"c","d","a","b"};
        String longestWord = findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }

    public static String findLongestWord(String s,String[] dic){
        //按照字符长度排序
        List<String> dicStrList = Arrays.stream(dic).sorted((o1, o2) -> {
            if(o1.length()!=o2.length()){
                return o2.length()-o1.length();
            }
            return o1.compareTo(o2);
        }).collect(Collectors.toList());
        String res="";
        for (String dicStr : dicStrList) {
            int i = 0;
            int j=0;
            while (i<dicStr.length()&&j<s.length()){
                char ch = s.charAt(j);
                if(ch==dicStr.charAt(i)){
                    i++;
                }
                j++;
            }
            if(i==dicStr.length()){
                return dicStr;

            }
        }
        return res;
    }
}
