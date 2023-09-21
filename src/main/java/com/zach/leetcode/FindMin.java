package com.zach.leetcode;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * 示例 3：
 *
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }

    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while (low<high){
            int mid = low+(high-low)/2;
            //中间值小于nums[high]，说明此时最小值在mid的左边，也有可能恰好就是mid
            if(nums[mid]<nums[high]){
                high=mid;
            }else {
                //中间值大于等于nums[high]，则说明最小值在mid的右侧，则令low右移
                low = mid+1;
            }
        }
        //low=high时，结束循环，最小值是low,
        /**
         * 由于数组不包含重复元素，并且只要当前的区间长度不为 111，pivot\it pivotpivot 就不会与 high\it highhigh 重合；而如果当前的区间长度为 111，这说明我们已经可以结束二分查找了。因此不会存在 nums[pivot]=nums[high]\textit{nums}[\textit{pivot}] = \textit{nums}[\textit{high}]nums[pivot]=nums[high] 的情况。
         *
         */
        return nums[low];
    }
}
