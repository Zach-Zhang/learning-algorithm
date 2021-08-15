package com.zach.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:和为 S 的两个数字
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 * @Author Zach
 * @Date 2021/8/15 7:44
 * Version :1.0
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        List<Integer> result = twoSum(array, 11);
        System.out.println(result);
    }

    /**
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较
     * 大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * @param array
     * @param sum
     * @return
     */
    public static List<Integer> twoSum(int[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        List<Integer> result = new ArrayList<>(2);
        while (i < j) {
            int target = array[i] + array[j];
            if (target < sum) {
                i++;
            } else if (target == sum) {
                result.add(array[i]);
                result.add(array[j]);
                break;
            } else {
                j--;
            }
        }
        return result;
    }
}
