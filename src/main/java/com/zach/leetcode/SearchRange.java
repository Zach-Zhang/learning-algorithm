package com.zach.leetcode;

/**
 *给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums =  {5,8,8,8,8,8,8,10,20};
        //查出第一个比target大的元素索引
        int start = searchRange(nums,8);
        //查找第一个比target+1大的元素，右区间=index-1;
        int end = searchRange(nums,9)-1;
        if(start==nums.length||nums[start]!=8){
            System.out.println(-1);
        }else {
            System.out.println(start+","+end);
        }
    }

    public static int searchRange(int[] nums,int target){
        if(nums==null||nums.length==0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        while (low<high){
            int mid = low+(high-low)/2;
            //查找第一个大于等于target的元素，若有多个，high指针会向左移动，直到找到第一个小于target的元素，此时high=low+1,low就是左区间
            if(nums[mid]>=target){
                high = mid;
            }else {
               low = mid+1;
            }
        }
        return low;

    }
}
