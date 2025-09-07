package com.zach.labuladong.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 *
 * A good subarray is a subarray where:
 *
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 *
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * Example 2:
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = new  int[]{23,2,4,6,7};
        boolean result = checkSubArraySumOptimize(nums, 6);
        System.out.println(result);

    }

    public static int[] calcPrefixSum(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        int[] prefixSum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            //计算0到i-1的累加和
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }
        return prefixSum;
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubArraySum(int[] nums,int k){
        if(nums==null||nums.length<=1){
            return false;
        }
        for (int i = 0; i < nums.length-1; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                 sum += nums[j];
                if(sum%k==0){
                    System.out.println("start="+i+",end="+j+",sum="+sum);
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 前缀和+哈希表解法
     * 核心思路：如果两个前缀和的余数相同，那么它们之间的子数组和就是k的倍数
     * 数学原理：
     * 假设 prefixSum[i] % k = r, prefixSum[j] % k = r (j > i)
     * 那么 (prefixSum[j] - prefixSum[i]) % k = 0
     * 即子数组 nums[i+1...j] 的和是k的倍数
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubArraySumOptimize(int[] nums,int k){
        //余数->该余数第一次出现的位置
        Map<Integer,Integer> prefixMod = new HashMap<>();
        //表示虚拟前缀和prefixSum[-1] = 0，让算法能够检测"从数组开头开始的长度≥2的子数组",统一处理：避免了需要单独处理两种情况（从开头vs不从开头）
        prefixMod.put(0,-1);
        int prefixSum = 0;
        for (int i = 0; i <nums.length; i++) {
            prefixSum += nums[i];
            int remainder = prefixSum % k;
            if(prefixMod.containsKey(remainder)){
                Integer preIndex = prefixMod.get(remainder);
                //子数组范围: nums[prevIndex+1 ... currentIndex]
                //prevIndex 是余数上次出现的位置
                if(i-preIndex>=2){
                    //prevIndex = 0 是余数5上次出现的索引位置，不是数组元素值
                    System.out.println("start="+(preIndex+1)+",end="+i+",sum="+(prefixSum-nums[preIndex]));
                    return true;
                }
            }else {
                //第一次遇到这个余数，记录位置
                prefixMod.put(remainder,i);
            }
        }
        return false;

    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                // ensures that the size of subarray is at least 2
                if (i - modSeen.get(prefixMod) > 1) {
                    System.out.println("start="+modSeen.get(prefixMod)+",end="+i+",sum="+prefixMod);
                    return true;
                }
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(prefixMod, i);
            }
        }

        return false;
    }
}
