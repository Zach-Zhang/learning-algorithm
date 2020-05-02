package com.zach.alogrithm.easy;

/**
 * @Classname FindMaxAverage
 * @Description:
 * @Date 2020/4/29 21:33
 * @Created by Zach
 */
public class FindMaxAverage {
    public static void main(String[] args) {
        //int[] nums = {1, 12, -5, -6, 50, 3};
        int[] nums = {-1};
        int k = 1;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }

    //方案一
    public static double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        double result = Integer.MIN_VALUE;
        int i = 0;
        int end = k - 1;
        while (end < length) {
            int sum = 0;
            for (int j = i; j <= end; j++) {
                sum += nums[j];
            }
            i++;
            end = i + k - 1;
            result = Math.max(result, sum);
        }
        return result / k;
    }

    //方案二
    public static double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;
        for (int i = k; i < nums.length; i++) {
            //这是一个窗口的滑动,每次滑动一格
            sum += (nums[i] - nums[i - k]);
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }

}
