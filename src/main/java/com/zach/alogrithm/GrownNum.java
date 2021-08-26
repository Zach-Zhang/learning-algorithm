package com.zach.alogrithm;

/**
 * @Description:int[] nums = new int[]{1, 2, 3, 3, 4, 5, 3, 4, 5, 6,3,4};￼
 * nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * @Author Zach
 * @Date 2021/8/26 17:31
 * Version :1.0
 */
public class GrownNum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 3, 4, 5, 6,3,4};
        int i = grownNum(nums);
        System.out.println(i);
    }

    public static int grownNum(int[] array) {
        int ret = 0;
        int len = array.length;
        int start = 0;

        for (int i = 0; i < len; i++) {
            //array[i] <= array[i - 1],表明i和i-1就不是一个递增的序列,所以递增序列的下标要从i开始
            if (i > 0 && array[i] <= array[i - 1]) {
                start = i;
            }
            ret = Math.max(ret, i - start + 1);
        }
        return ret;
    }


}
