package com.zach.leetcode;

/**
 * @Description:
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * @Author Zach
 * @Date 2023-08-01 21:44
 * Version :1.0
 */
public class FindKthLargestV2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,7,6,10};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    private static int findKthLargest(int[] nums,int k){
        int l=0;
        int h=nums.length-1;
        k=nums.length-k;
        while (l<h){
            int j = partition(l,h,nums);
            //找到倒数第k个元素
            if(j==k){
               break;
            }else if(j<k){
                //l右移
               l=j+1;
            }else {
                //h左移
                h=j-1;
            }
        }
        return nums[k];
    }

    /**
     * 分区
     * @param l
     * @param h
     * @param nums
     * @return
     */
    private static int partition(int l, int h, int[] nums) {
        int i = l;
        int j = h+1;
        while (true){
            //从左往右找出第一个比nums[l]大的元素
            while (nums[++i]<nums[l]&&i<h);
            //从右往左找出第一个比nums[l]小的元素
            while (nums[--j]>nums[l]&&j>l);
            if(i>=j){
                break;
            }
            //交换元素的位置
            swap(i,j,nums);
        }
        //交换l与j的位置，因为此时nums[l]>nums[j]或者nums[i]>nums[l],i=j
        swap(l,j,nums);
        return j;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }


}
