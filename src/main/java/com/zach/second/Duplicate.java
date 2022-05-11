package com.zach.second;

/**
 * @Description: 在一个长度为 n 的数组里的所有数字都在 0 到n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重
 * 复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * @Author Zach
 * @Date 2022/4/12 7:58
 * Version :1.0
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] a = {2,3,1,0,2,5};
        int duplicate = duplicate(a);
        System.out.println(duplicate);
    }

    public static int duplicate(int[] a) {
        for (int i = 0; i < a.length; i++) {
            while (a[i] != i) {
                if (a[a[i]] == a[i]) {
                    return a[i];
                }
                swap(a, i, a[i]);
            }

        }
        return -1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
