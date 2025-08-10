package com.zach.labuladong.array;

import com.alibaba.fastjson2.JSON;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] nums2 = new int[]{-1,1,0,-3,3};
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] result = pes.productExceptSelf2(nums);
        System.out.println(JSON.toJSON(result));


    }

    public ProductExceptSelf(){

    }

    public int[] productExceptSelf(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        int index = 0;
        int len = nums.length;
        int[] answer = new int[len];

        while (index<len){
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if(index!=i) {
                    product = product * nums[i];
                }
            }
            answer[index++] = product;
        }
        return answer;

    }

    public int[] productExceptSelf2(int[] nums){
        int n = nums.length;
        int[] answer = new  int[n];
        Arrays.fill(answer,1);
        int curr = 1;
        //从左到右遍历，计算每个位置左边的乘积
        for (int i = 0; i < n; i++) {
            answer[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        //从右到左遍历，计算右边乘积并更新答案
        for (int i = n-1; i >=0; i--) {
            answer[i] *= curr;
            curr *= nums[i];
        }
        return answer;
    }
}
