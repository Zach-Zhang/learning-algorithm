package com.zach.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray2(nums));
    }

    /**
     * 动态规划
     * 设dp[i]表示 以i结尾的连续子数组的和
     * 状态转移方程
     * dp[i] = {
     *     dp[i-1]+nums[i];  dp[i-1]>0
     *     nums[i];          dp[i-1]<=0
     *
     * }
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums){
        //dp[i] 表示在i结尾的连续子数组的和
        int[] dp = new int[nums.length];
        int res = 0;
        dp[0]= nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]>0){
                //dp[i] = dp[i]-1>0
                dp[i] = dp[i-1]+nums[i];
            }else {
                //dp[i]等于nums[i]
                dp[i] = nums[i];
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 滚动变量方法优化空间
     * dp[i]的值只跟dp[i-1]有关
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums){
        int pre= 0;
        int res=0;
        for (int num : nums) {
            //dp【i-1]<0,则pre+num大，否则num大
            pre = Math.max(pre+num,num);
            res = Math.max(pre,res);
        }
        return pre;
    }
}
