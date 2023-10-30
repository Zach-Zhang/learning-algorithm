package com.zach.labuladong;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int num = coinChange(coins, 22);
        System.out.println(num);
    }

    /**
     * 定义状态转移方程
     * 确定状态: 硬币数量无限，唯一确定状态是目标金额amount
     * dp函数定义： 当前目标金额是n，至少需要dp[n]个硬币凑出该金额
     * 确定选择最优：也就是对于每个状态， 可以做出什么选择改变当前状态。 具体到这个问题， ⽆论当的⽬标⾦额是多少， 选择就是从⾯额列表coins 中选择⼀个硬币， 然后⽬标⾦额就会减少
     * 明确base case: 目标金额为0时，所需硬币数量为0，当目标金额小于0，无解，返回-1
     * dp[n]:{
     *     0 n=0
     *     -1 n<0
     *     min{dp[n-coin}+1 (coin∈coins n>0)
     * }
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins,int amount){
        //初始化dp数组，凑成amount金额，最多需要amount个硬币，
        int[] dp = new int[amount+1];
        //初始化amount+1，便于取最小值
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <=amount; i++) {
            for (int coin : coins) {
                if(i-coin<0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }
}
