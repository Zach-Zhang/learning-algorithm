package com.zach.alogrithm.easy;

/**
 * Given an integer array nums, find
 * the contiguous subarray (containing at least one number) which has the largest sum and
 * return its sum.
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {20, 1, -3, 4, -1, 2, 1, -5, 4};
        //int max = maxSubArray1(nums);
        int max = maxSubArray2(nums);
        System.out.println(max);
    }

    //方案一：
    public static int maxSubArray1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] arr = new int[len];
        arr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            arr[i] = Math.max(nums[i], arr[i - 1] + nums[i]);
        }

        int res = arr[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, arr[i]);
        }
        return res;
    }

    //方案二：
    public static int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] arr = new int[len];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(nums[i], max + nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
