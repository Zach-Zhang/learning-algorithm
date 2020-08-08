package com.zach.frequency;

import java.util.ArrayList;

/**
 * @Classname MinNumberInRotateArray
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，
 * 如[1,2,3,4],旋转数组[2,3,4,1],输出是1
 * 输出旋转数组的最小元素。
 * @Date 2020/8/8 19:52
 * @Author: Zach
 * @version: V1.0
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        int[] A = new int[]{1, 1, 1, 0, 1};
        int i = minNumberInRotateArray(A);
        System.out.println(i);
    }

    public static int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int low = 0;
        int high = len - 1;
        while (low < high) {
            //二分法取中间索引,(how-low)是防止直接low++high会int溢出
            int mid = low + (high - low) / 2;
            //数组中出现相等的元素,只能顺序查找
            if (array[low] == array[mid] && array[mid] == array[high]) {
                return minNum(array, low, high);
            } else if (array[mid] <= array[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return array[low];
    }

    /**
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int minNum(int[] array, int low, int high) {
        for (int i = low; i < high; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[low];
    }
}
