package com.zach.second;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @Author Zach
 * @Date 2022/4/14 14:57
 * Version :1.0
 */
public class LongestSubStr {
    public static void main(String[] args) {
        Integer len = findLongest("abcbad");
        System.out.println(len);
    }

    public static Integer findLongest(String sourceStr) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < sourceStr.toCharArray().length; i++) {
            char c = sourceStr.charAt(i);
            if (map.containsKey(c)) {
                //更新左边界
                left = Math.max(left, map.get(c) + 1);
            }
            //更新下标
            map.put(c, i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

    /**
     * 双指针实现滑动窗口
     *
     * @param sourceStr
     * @return
     */
    public static Integer findLongest2(String sourceStr) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int len = sourceStr.length();
        if (len <= 1) {
            return 1;
        }
        while (right < len) {
            while (set.contains(sourceStr.charAt(right))) {
                set.remove(sourceStr.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
            set.add(sourceStr.charAt(right));
            right++;
        }
        return max;
    }

    public static Integer findLongest3(String sourceStr) {
        int left = 0;
        int right = 0;
        int max = 1;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int len = sourceStr.length();
        if (len <= 1) {
            return len;
        }
        while (right < len) {
            char rightChar = sourceStr.charAt(right);
            Integer rightIndex = indexMap.getOrDefault(rightChar, 0);
            left = Math.max(left, rightIndex);
            max = Math.max(max, rightIndex - left + 1);
            //在这里维护了重复之后，left要跳转到 重复字符的下一个位置
            indexMap.put(rightChar, right + 1);
            right++;
        }
        return max;
    }
}
