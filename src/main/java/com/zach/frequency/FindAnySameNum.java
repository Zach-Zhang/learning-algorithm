package com.zach.frequency;

/**
 * @Classname FindAnySameNum
 * @Description: 题目描述
 * 在一个长度为 n 的数组里的所有数字都在 0 到n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字,
 *要求时间复杂度O(n),空间复杂度O(1)
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 * @Date 2020/6/9 21:59
 * @Author: Zach
 * @version: V1.0
 */
public class FindAnySameNum {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 0, 4, 5};
        //int anySameNum = findAnySameNum(A);
        int anySameNum = findDuplicateNum(A);
        System.out.println(anySameNum);
    }

    //这种揭发不符合时间复杂度O(n)的要求
    public static int findAnySameNum(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    return num;
                }
            }
        }
        return -1;
    }
    //于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
    public static int findDuplicateNum(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i) {
                if (A[i] == A[A[i]]) {
                    return A[i];
                }
                //交换元素
                swap(A, i, A[i]);
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
