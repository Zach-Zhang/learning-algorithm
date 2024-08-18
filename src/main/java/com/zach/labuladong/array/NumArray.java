package com.zach.labuladong.array;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class NumArray {
    /**
     * 前缀和数组，pre[i]代表0到i-1的和
     */
    private int[] preSum;

    public NumArray(int[] numArray) {
        //初始化前缀和
        if(numArray!=null&&numArray.length>0){
           int len = numArray.length;
           preSum = new int[len+1];
            //计算0到i-1的累加和
            for (int i = 1; i <= len; i++) {
                preSum[i] = preSum[i-1]+numArray[i-1];
            }
        }
    }

    /**
     * 计算left 到right之间的累计和
     * @param left
     * @param right
     * @return
     */
    public int sumRegion(int left,int right){
        return preSum[right+1]-preSum[left];
    }

    public static void main(String[] args) {
        int[] array = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(array);
        int ret = numArray.sumRegion(0, 5);
        System.out.println(ret);
    }
}
