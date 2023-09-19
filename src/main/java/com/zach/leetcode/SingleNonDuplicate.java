package com.zach.leetcode;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        int rest = singleNonDuplicate(nums);
        System.out.println(rest);
    }

    /**
     *二分法
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while (low<high){
            int mid = low+(high-low)/2;
            //若mid为偶数，则判断nums[mid]==nums[mid+1],
            //若mid为奇数，则判断nums[mid]==nums[mid-1],
            //若以上判断是相等，则目标元素索引在mid的右边，移动low=mid+1
            //否则目标元素在mid的左边，令high=mid,mid也有可能是结果
            //mid为偶数 mid^1==mid+1,mid为奇数，mid-1==mid
            //目标元素的下标一定是偶数，因为左右两边都有偶数个元素（成对）
            if(nums[mid]==nums[mid^1]){
                low = mid+1;
            }else {
                high=mid;
            }
        }
        return nums[low];
    }
}
