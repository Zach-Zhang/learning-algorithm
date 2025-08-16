package com.zach.labuladong.array;

/**
 * Given an integer array `nums` and two integers `lower` and `upper`, return *the number of range sums that lie in* `[lower, upper]` *inclusive*.
 * Range sum `S(i, j)` is defined as the sum of the elements in `nums` between indices `i` and `j` inclusive, where `i <= j`.
 *  
 * **Example 1:**
 *
 * ```
 * Input: nums = [-2,5,-1], lower = -2, upper = 2
 * Output: 3
 * Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
 *
 * ```
 *
 * **Example 2:**
 *
 * ```
 * Input: nums = [0], lower = 0, upper = 0
 * Output: 1
 * ```
 */
public class CountRangeSum {
   private final int[] preSum;
    public static void main(String[] args) {
        int[] nums = new int[]{-2,5,-1};
        int[] nums2 = new int[]{0};
        CountRangeSum countRangeSum = new CountRangeSum(nums2);
        int count = countRangeSum.countRangeSum(nums2, 0, 0);
        System.out.println(count);

        int result = countRangeSum2(nums, -2, 2);
        System.out.println(result);


    }

    public CountRangeSum(int[] nums){
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            //表示从0到i-1的和
            preSum[i] = preSum[i-1]+nums[i-1];
        }
    }
    public int rangeSum(int right,int left){
        return preSum[right+1]-preSum[left];
    }
    public int countRangeSum(int[] nums,int lower,int upper){
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int result = rangeSum(j, i);
                if(result<=upper && result>=lower){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 归并排序最优解
     */
    public static int countRangeSum2(int[] nums,int lower,int upper){
        int n = nums.length;
        if(n==0){
            return 0;
        }
        //计算前缀和
        int[] prefixSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }
        return mergeSort(prefixSum,0,n+1,lower,upper);
    }

    /**
     * 归并排序并统计满足条件的区间数量
     * @param prefixSum
     * @param left
     * @param right
     * @param lower
     * @param upper
     * @return
     */
    public static  int mergeSort(int[] prefixSum,int left,int right,int lower,int upper){
        if(right-left<=1){
            return 0;
        }
        int mid = left + (right-left) /2;
        int count = mergeSort(prefixSum,left,mid,lower,upper)+mergeSort(prefixSum,mid,right,lower,upper);

        //统计跨越mid的区间数量
        //对于左半部分的每个前缀和prefixSum[i],找到右半部分满足条件的前缀和prefixSum[j]的个数
        int j = mid;
        int k = mid;
        for (int i = left; i < mid; i++) {
            //找到第一个满足prefixSum[j] >= preSum[i]+lower的j
            while (j<right && prefixSum[j]-prefixSum[i]<lower){
                j++;
            }
            //找到第一个满足preSum[k]>prefixSum[i]+upper的k
            while (k<right && prefixSum[k]-prefixSum[i]<=upper){
                k++;
            }
            //【j,k)区间内所有的前缀和都满足条件
            count += k-j;
        }

        //归并排序的合并过程
        int[] temp = new int[right-left];
        int i = left, p = mid,t=0;
        while (i<mid && p<right){
            if(prefixSum[i]<=prefixSum[p]){
                temp[t++] = prefixSum[i++];
            }else {
                temp[t++] = prefixSum[p++];
            }
        }

        while (i<mid){
            temp[t++] = prefixSum[i++];
        }
        while (p<right){
            temp[t++] = prefixSum[p++];
        }
        //将排序后的结果复制回原数组
        System.arraycopy(temp,0,prefixSum,left,temp.length);
        return count;
    }
}
