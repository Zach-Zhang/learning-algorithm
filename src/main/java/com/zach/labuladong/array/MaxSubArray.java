package com.zach.labuladong.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数 k，找到数组中和等于 k 的最长子数组的长度。如果不存在这样的子数组，返回 0 代替
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 的和为 3 且长度最长:ml-citation{ref="1,2" data="citationList"}
 *
 * 输入: nums = [-2, -1, 2, 1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 的和为 1 且长度最长:ml-citation{ref="1,2" data="citationList"}
 *
 * 约束条件
 * 1 <= nums.length <= 2 × 10
 * 5
 * -10
 * 4 <= nums[i] <= 10
 * 4
 * -10
 * 9 <= k <= 10
 * 9[1][4]^
 */
public class MaxSubArray {

    /**
     * prefixSum[i] = nums[0] + nums[1] + ... + nums[i]
     * 对于子数组 nums[i+1] 到 nums[j]（包含两端），其和等于：
     * 子数组和 = prefixSum[j] - prefixSum[i]
     * 推导过程：
     * prefixSum[j] = nums[0] + nums[1] + ... + nums[i] + nums[i+1] + ... + nums[j]
     * prefixSum[i] = nums[0] + nums[1] + ... + nums[i]
     * 相减得到：prefixSum[j] - prefixSum[i] = nums[i+1] + nums[i+2] + ... + nums[j]
     * 正好是从位置 i+1 到位置 j 的子数组和
     * 我们要找和为k的子数组，即：
     * nums[i+1] + nums[i+2] + ... + nums[j] = k
     * 根据前缀和公式，这等价于：
     * prefixSum[j] - prefixSum[i] = k
     * 变换一下得到：
     * prefixSum[i] = prefixSum[j] - k
     * 长度计算：
     * 子数组的起始位置是 i+1
     * 子数组的结束位置是 j
     * 子数组的长度是 j - (i+1) + 1 = j - i
     * 特殊情况：从开头开始的子数组
     * 当子数组从索引0开始时，我们没有"前面的前缀和"可以减去。为了统一处理，我们定义：
     * prefixSum[-1] = 0（表示空前缀的和为0）
     * 这样从索引0到j的子数组和就是 prefixSum[j] - prefixSum[-1] = prefixSum[j] - 0
     * 长度计算：j - (-1) = j + 1，正好是从0到j的元素个数
     * 为什么能保证找到最长的？
     * 我们只记录每个前缀和的第一次出现位置
     * 当在位置j寻找target时，找到的一定是最早的那个位置
     * 最早的位置意味着最长的子数组长度（j - 最早位置 最大）
     *
     *
     *
     * 为什么单次遍历能找到中间的子数组？
     * 关键理解：任何子数组都有一个结尾位置，当我们遍历到那个位置时，就能发现它。
     * 让我用一个具体例子说明：
     * 假设数组是 [1, 2, -3, 1, 1, 1, -1, 2]，我们要找和为3的子数组。
     * 假设最长的子数组是中间的 [1, 1, 1]（位置3到5），和确实为3。
     * 算法是如何发现这个中间子数组的？
     *
     * 当j=2时：我们计算并记录了 prefixSum[2] = 1+2+(-3) = 0
     * 当j=5时：
     *
     * 我们计算 prefixSum[5] = 1+2+(-3)+1+1+1 = 3
     * 我们寻找 target = prefixSum[5] - k = 3 - 3 = 0
     * 我们在哈希表中找到 prefixSum[2] = 0
     * 因此发现子数组 nums[3:6] = [1,1,1]，长度 = 5-2 = 3
     *
     *
     *
     * 关键洞察：
     *
     * 中间子数组 [1,1,1] 的起始位置是3，结尾位置是5
     * 当我们遍历到结尾位置5时，我们检查的是：从某个更早的位置到位置5的所有可能子数组
     * 由于位置2的前缀和已经在之前被记录，我们能够"回溯"找到这个中间子数组
     *
     * 为什么不会遗漏任何子数组？
     * 数学证明：
     * 对于任意和为k的子数组 nums[i:j+1]：
     *
     * 它必定有一个确定的结尾位置j
     * 当算法遍历到位置j时，会计算 prefixSum[j]
     * 会寻找 target = prefixSum[j] - k
     * 如果子数组和为k，则必有 prefixSum[j] - prefixSum[i-1] = k
     * 即 prefixSum[i-1] = target
     * 只要位置i-1的前缀和在之前被记录过，就能找到这个子数组
     *
     * 时间顺序保证：
     *
     * 我们从左到右遍历，位置i-1一定在位置j之前被访问
     * 因此 prefixSum[i-1] 一定已经在哈希表中（如果它之前出现过）
     *
     * 为什么能保证找到最长的？
     * 哈希表策略：
     *
     * 我们只记录每个前缀和的第一次出现位置
     * 当在位置j寻找target时，找到的一定是最早的那个位置
     * 最早的位置意味着最长的子数组长度（j - 最早位置 最大）
     *
     * 可视化理解
     * 数组: [1, 2, -3, 1, 1, 1, -1, 2]
     * 索引:  0  1   2  3  4  5   6  7
     *
     * 前缀和计算过程：
     * j=0: prefixSum=1,  记录 {1: 0}
     * j=1: prefixSum=3,  记录 {1: 0, 3: 1}
     * j=2: prefixSum=0,  记录 {1: 0, 3: 1, 0: 2}  ← 关键记录
     * j=3: prefixSum=1,  已存在，不更新
     * j=4: prefixSum=2,  记录 {1: 0, 3: 1, 0: 2, 2: 4}
     * j=5: prefixSum=3,  寻找target=0 → 找到位置2! ← 发现中间子数组
     * 子数组 nums[3:6] = [1,1,1]，长度=5-2=3
     * 这就是为什么单次从左到右遍历就能找到所有可能的子数组，包括那些位于数组中间的子数组。算法的精妙之处在于通过前缀和将"寻找子数组"转化为"寻找两个位置的差值"，而哈希表让我们能够高效地进行这种查找。
     *
     */
    public  static int calcMaxSubArrayLength(int[] nums,int k){
        
        //记录前缀和第一次出现的位置
        Map<Integer,Integer> preSumIndex = new HashMap<>();
        //前缀和为0，在位置-1   方便计算从索引0开始的子数组
        preSumIndex.put(0,-1);
        //当前前缀和
        int preSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int target = preSum-k;
            if(preSumIndex.containsKey(target)){
                Integer prevIndex = preSumIndex.get(target);
                int currentLen = i-prevIndex;
                maxLen = Math.max(maxLen,currentLen);
            }

            //只记录第一次出现前缀和的位置
            if(!preSumIndex.containsKey(preSum)){
                preSumIndex.put(preSum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int ret = calcMaxSubArrayLength(nums, 3);
        System.out.println(ret);
    }
}
