package com.zach.frequency;

/**
 * @Description: 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个
 * 数组中的逆序对的总数。
 * @Author Zach
 * @Date 2021/8/6 20:57
 * Version :1.0
 */
public class ReversePairs {
    static int[] nums;
    static int[] tmp;

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5,6, 4};
        int count = reversePairs(nums);
        System.out.println(count);
    }

    public static int reversePairs(int[] array) {
        nums = array;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private static int mergeSort(int l, int r) {
        //终止条件
        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        //合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            //m及其左边元素合并完毕,把右边剩下的放入合并后的数组
            if (i == m + 1) {
                nums[k] = tmp[j++];
                //m+1及其右边元素合并完毕,把左边剩下的放入合并后的数组 或者 左边数组的元素小于等于右边,将左边数组的元素放入结果数组中,并让索引i加1
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                //右边数组的元素小于左边,将右边数组的元素其放入结果数组中,并让索引j加1
                nums[k] = tmp[j++];
                res += m - i + 1;//统计逆序对
            }
        }
        return res;

    }
}
