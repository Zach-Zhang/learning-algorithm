package com.zach.leetcode;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 */
public class CanPlaceFlower {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        boolean flag = canPlaceFlower(flowerbed, 2);
        System.out.println(flag);
    }

    /**
     *  dp[i][0] = dp[i-2][1]+dp[i+2][1] i-2>=0 && i+2<len-1
     *  dp[i][1] = dp[
     * @param nums
     * @param n
     * @return
     */
    public static boolean canPlaceFlower(int[] nums,int n){
        if(nums==null||nums.length==0){
            return false;
        }
        if(n<=0){
            return true;
        }
        int len = nums.length;
        int cnt=0;
        //cnt>=n时，就跳出循环，已满足种植n多花的条件，无需计算
        for (int i = 0; i < len&&cnt<n; i++) {
            //已经种花的，跳过，前后不能种花
            if(nums[i]==1){
                continue;
            }
            //i的前一个节点种花情况
            int pre = i==0?0:nums[i-1];
            //i的后一个节点种花情况
            int next = i==len-1?0:nums[i+1];
            if(pre==0&&next==0){
                cnt++;
                //标记位置i已种植过，防止重复统计，（下一轮i-1会重复统计）
                nums[i]=1;
            }
        }
        return cnt>=n;
    }
}
