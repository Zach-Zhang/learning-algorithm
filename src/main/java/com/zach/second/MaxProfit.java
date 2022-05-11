package com.zach.second;

/**
 * @Description: 股票的最大利润
 * 可 以有一次买入和一次卖出，买入必须在前。求最大收益
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
 * @Author Zach
 * @Date 2022/4/18 8:52
 * Version :1.0
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int[] nums2 = {7, 6, 4, 3, 1};
        int maxProfit = maxProfit2(nums);
        System.out.println(maxProfit);
    }

    /**
     * 暴力求解
     *
     * @param nums
     * @return
     */
    public static int maxProfit(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            //买入必须在前
            for (int j = i + 1; j < nums.length; j++) {
                maxProfit = Math.max(maxProfit, nums[j] - nums[i]);
            }
        }
        return maxProfit;
    }

    /**
     * 贪心思想
     *
     * @param nums
     * @return
     */
    public static int maxProfit2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int maxProfit = 0;
        //假设nums[0]就是最低的价格
        int minPrice = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minPrice = Math.min(minPrice, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - minPrice);
        }
        return maxProfit;
    }
}
