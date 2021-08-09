package com.zach.frequency;

/**
 * @Description:数字在排序数组中出现的次数
 * Input:
 * nums = 1, 2, 3, 3, 3, 3, 4, 6
 * K = 3
 * Output:
 * 4
 * @Author Zach
 * @Date 2021/8/9 7:52
 * Version :1.0
 */
public class GetNumOfK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 4, 6,6};
        System.out.println(getNumOfK(nums,6));
    }

    public static int getNumOfK(int[] nums, int k) {
        int first = binarySearch(nums, k);
        int last = binarySearch(nums, k + 1);
        return (first == nums.length || nums[first] != k) ? 0 : last - first;
    }

    private static int binarySearch(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] >= k) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }
}
