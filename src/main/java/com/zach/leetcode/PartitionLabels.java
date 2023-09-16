package com.zach.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * 示例 2：
 *
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 */
public class PartitionLabels {
    public static void main(String[] args) {
        List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res);
    }

    /**
     *
     * @param target
     * @return
     */
    public static List<Integer> partitionLabels(String target){
        int[] last = new int[26];
        for (int i = 0; i < target.length(); i++) {
            //记录字符最后一次出现的索引位置
            last[target.charAt(i)-'a']=i;
        }
        int start = 0;
        int end=0;
        List<Integer> res = new ArrayList<>(target.length());
        for (int i = 0; i < target.length(); i++) {
            //求出当前字符最后一次出现的位置index，最后一次出现的index一定是最大值
           end =  Math.max(last[target.charAt(i)-'a'],end);
           if(i==end){
               res.add(end-start+1);
               start = end+1;
           }
        }
        return res;
    }
}
