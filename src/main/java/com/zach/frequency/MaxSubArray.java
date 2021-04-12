package com.zach.frequency;

/**
 * @Description:
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 要求时间复杂度为O(n)。
 * @Author Zach
 * @Date 2021/4/12 11:38
 * Version :1.0
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    /**
     * 计算和最大的连续子数组
     *
     * @param array
     * @return
     */
    public static int maxSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            result = Math.max(array[i], result);
        }
        return result;
    }
}
