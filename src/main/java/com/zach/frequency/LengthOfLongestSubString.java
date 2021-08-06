package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重
 * 复字符的子字符串为 acfr，长度为 4
 * @Author Zach
 * @Date 2021/7/7 21:26
 * Version :1.0
 */
public class LengthOfLongestSubString {
    public static void main(String[] args) {
        String str = "arabcacfr";
        int len = lengthOfLongestSubString2(str);
        System.out.println(len);
    }

    /**
     * 动态规划+字典表
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubString(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }

        Map<Character, Integer> dic = new HashMap<>(str.length());
        int res = 0;
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            //初始化字典
            Integer index = dic.getOrDefault(str.charAt(i), -1);
            //更新hash表
            dic.put(str.charAt(i), i);
            //dp[i-1]->dp[i],temp<i-index,表示str[index]是在dp[i-1]区间之外的,dp[i]=dp[i-1]+1,反之dp[i]=i-index
            temp = temp < i - index ? temp + 1 : i - index;
            res = Math.max(res, temp);
        }
        return res;
    }

    /**
     * 双指针法+字典表
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubString2(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        int i = -1;
        int res = 0;
        Map<Character, Integer> dic = new HashMap<>(str.length());
        for (int j = 0; j < str.length(); j++) {
            if (dic.containsKey(str.charAt(j))) {
                //更新指针的i,使得[i+1,j]之间没有重复字符
                i = Math.max(i, dic.get(str.charAt(j)));
            }
            //更新字典
            dic.put(str.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
