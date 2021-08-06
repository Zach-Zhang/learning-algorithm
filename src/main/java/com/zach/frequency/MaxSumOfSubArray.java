package com.zach.frequency;

/**
 * @Description: 连续子数组最大的和
 * @Author Zach
 * @Date 2021/6/27 8:11
 * Version :1.0
 */
public class MaxSumOfSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        int res = maxSumOfSubArray(array);
        System.out.println(res);

    }

    public static int maxSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxSum = array[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            maxSum = maxSum <= 0 ? array[i] : array[i] + maxSum;
            res = Math.max(res, maxSum);
        }
        return res;
    }
}
