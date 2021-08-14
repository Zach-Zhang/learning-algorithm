package com.zach.frequency;

/**
 * @Description: singleNumber
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Author Zach
 * @Date 2021/8/14 10:34
 * Version :1.0
 */
public class SingleNumber {
    public static void main(String[] args) {

    }

    /**
     * 任何数和 0 做异或运算，结果仍然是原来的数，
     * 任何数和其自身做异或运算，结果是 0，
     * 异或运算满足交换律和结合律，
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
