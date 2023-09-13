package com.zach.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence2("ahbadc","aac"));
    }

    /**
     * 暴力解法，无法解决重复字符串问题
     * @param source
     * @param subStr
     * @return
     */
    public static boolean isSubSequence(String source,String subStr){
        if(StringUtils.isBlank(source)&&StringUtils.isNotBlank(subStr)||(StringUtils.isBlank(subStr)&&StringUtils.isNotBlank(source))){
            return false;
        }
        if(StringUtils.isBlank(source)&&StringUtils.isBlank(subStr)){
            return true;
        }
        Map<Character,Integer> charMap = new HashMap<>(subStr.length());
        char pre=subStr.charAt(0);
        charMap.put(pre,0);
        for (int i = 1; i < subStr.toCharArray().length; i++) {
            char ch = subStr.charAt(i);
            int index = source.indexOf(ch);
            //不包含字符ch
            if(index<0){
                return false;
            }
            //若有重复字符，只比较前一个即可
            if(!charMap.containsKey(ch)){
                if(pre!=ch){
                    //相对顺序是否发生改变
                    if(index<charMap.get(pre)){
                        return false;
                    }else {
                        //指针pre指向下一个字符
                        pre = ch;
                    }
                }
                charMap.put(ch,index);
            }
        }
        return charMap.size()==subStr.length();
    }

    /**
     * 双指针，通用解法，兼容重复字符
     * @param source
     * @param subStr
     * @return
     */
    public static boolean isSubsequence2(String source,String subStr){
        if(StringUtils.isBlank(source)&&StringUtils.isNotBlank(subStr)||(StringUtils.isBlank(subStr)&&StringUtils.isNotBlank(source))){
            return false;
        }
        if(StringUtils.isBlank(source)&&StringUtils.isBlank(subStr)){
            return true;
        }
        int m = source.length();
        int n = subStr.length();
        int i = 0;
        int j = 0;
        while (i<m&&j<n){
            if(source.charAt(i)==subStr.charAt(j)){
                j++;
            }
            i++;
        }
        return j==n;
    }
}
