package com.zach.alogrithm.easy;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4};
        int len = removeDuplicates(nums);
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[count]!=nums[i]){
                nums[++count]=nums[i];
            }
        }
        return ++count;
    }
}
