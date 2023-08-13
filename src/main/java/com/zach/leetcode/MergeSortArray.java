package com.zach.leetcode;

/**
 * @Description: 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @Author Zach
 * @Date 2023-06-13 8:03
 * Version :1.0
 */
public class MergeSortArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int[] mergeArray = mergeArray(nums1, 3, nums2, 3);
        System.out.println(mergeArray.toString());
    }

    public static int[] mergeArray(int[] num1, int m, int[] num2, int n) {
        int i = m - 1;
        int j = n - 1;
        int mergeIndex = m + n - 1;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                num1[mergeIndex--] = num2[j--];
            } else if (j < 0) {
                num1[mergeIndex--] = num1[i--];
            } else if (num1[i] <= num2[j]) {
                num1[mergeIndex--] = num2[j--];
            } else {
                num1[mergeIndex--] = num1[i--];
            }
        }
        return num1;
    }
}
