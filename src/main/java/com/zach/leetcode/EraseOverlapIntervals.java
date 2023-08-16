package com.zach.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @Author Zach
 * @Date 2023-08-15 17:09
 * Version :1.0
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] interval = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        int[][] interval2 = new int[][]{{1,2},{1,2},{1,2}};
        int[][] interval3 = new int[][]{{1,2},{2,3}};
        int count = eraseOverlapInterval2(interval3);
        System.out.println(count);
    }

    /**
     * 动态规划，转换成先找到最多数量互不重叠的区间
     * @param nums
     * @return
     */
    public static int eraseOverlapInterval1(int[][] nums){
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums, Comparator.comparingInt(n -> n[0]));
        int len = nums.length;
        //可以选出的区间最大值
        int[] f = new int[len];
        Arrays.fill(f,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                //找到右边比左边小的区间
                if(nums[j][1]<=nums[i][0]){
                    f[i]= Math.max(f[i],f[j]+1);
                }
            }
        }
        return len-Arrays.stream(f).max().getAsInt();
    }

    /**
     * 贪心算法
     * 不断寻找右端点在首个区间右端点左侧的区间，然后将首个区间替换成该区间，当无法替换时，首个区间就是右端点最小的那个区间
     * @param nums
     * @return
     */
    public static int eraseOverlapInterval2(int[][] nums){
        if(nums.length==0){
            return 0;
        }
        //按照区间的右端点排序
        Arrays.sort(nums,Comparator.comparingInt(n->n[1]));
        int right = nums[0][1];
        //不重复区间，最少也有一个
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //与上一个区间不重合
            if(nums[i][0]>=right){
                count++;
                right = nums[i][1];
            }
        }
        return nums.length-count;
    }
}
