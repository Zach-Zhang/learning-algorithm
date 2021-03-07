package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * @Author Zach
 * @Date 2021/3/7 11:29
 * Version :1.0
 */
public class PermutationString {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(permutationString(str));
    }

    public static List<String> permutationString(String str) {
        if (StringUtils.isEmpty(str)) {
            return result;
        }
        char[] chars = str.toCharArray();
        //排序
        Arrays.sort(chars);
        //深度搜索+回溯算法排列
        backTracking(chars, new boolean[chars.length], new StringBuilder());
        return result;
    }

    private static void backTracking(char[] chars, boolean[] hasUsed, StringBuilder strAppend) {
        //说明所有的元素都已经遍历完了,所有的可能都排列出来了
        if (strAppend.length() == chars.length) {
            System.out.println(strAppend.toString());
            result.add(strAppend.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            //如果已经使用过,则跳过,回溯算法的剪枝操作
            if (hasUsed[i]) {
                continue;
            }
            //保证不重复(经过上面排序操作,相同的元素,是相邻排列的,)
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            strAppend.append(chars[i]);
            backTracking(chars, hasUsed, strAppend);
            //撤销操作,撤销到上一个元素
            strAppend.deleteCharAt(strAppend.length() - 1);
            hasUsed[i] = false;

        }

    }

}
