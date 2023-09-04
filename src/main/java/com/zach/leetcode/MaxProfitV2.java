package com.zach.leetcode;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 *
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 */
public class MaxProfitV2 {
    int res;
    public static void main(String[] args) {
        int[] price =  {7,1,5,3,6,4};
        int profit = new MaxProfitV2().maxProfit2(price);
        System.out.println(profit);
    }

    /**
     * 暴力解法
     * @param price
     * @return
     */
    public int maxProfit1(int[] price){
        if(price==null||price.length<2){
            return 0;
        }
        this.res=0;
        //初始状态是0，表示未持有股票
        dfs(price,0,price.length,0,0);
        return res;
    }

    /**
     * 递归回溯所有的状态
     * @param price 价值数组
     * @param index 索引
     * @param len   数组长度
     * @param status   0表示不持有股票，1表示持有股票
     * @param profit    当前获得利润
     * @return
     */
    private  void dfs(int[] price,int index,int len,int status,int profit){
        if(index==len){
            //计算所有状态组合情况下，最大的利润值
            this.res=Math.max(res,profit);
            return;
        }
        //计算下一天情况
        dfs(price,index+1,len,status,profit);

        //计算相反情况
        if(status==0){
            //尝试持有股票，买入
            dfs(price,index+1,len,1,profit-price[index]);
        }else {
            //尝试卖出股票
            dfs(price,index+1,len,0,profit+price[index]);
        }
    }

    /**
     * 动态规划
     * 动态转移方程
     * 持有现金
     * dp[i][0] = max{dp[i-1[0],dp[i-1]+price[i]}
     * 持有股票
     * dp[i][1] = max{dp[i-1][1],dp[i-1][0]-price[i]}
     * 由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 dp[n−1][0]\textit{dp}[n-1][0]dp[n−1][0] 的收益必然是大于 dp[n−1][1]\textit{dp}[n-1][1]dp[n−1][1] 的，最后的答案即为 dp[n−1][0]\textit{dp}[n-1][0]dp[n−1][0]。
     * @param price
     * @return
     */
    public static int maxProfit2(int[] price){
        if(price==null||price.length==0){
            return 0;
        }
        int len = price.length;
        //第二个维度数组，0表示持有现金，1表示持有股票
        int[][] dp = new int[len][2];
        //默认情况，持有现金，利润为0
        dp[0][0] = 0;
        //持有股票，利润等于当天股价相反数
        dp[0][1] = -price[0];
        for (int i = 1; i < len; i++) {
            //第i天持有现金的最大利润等于i-1天持有现金利润或第i-1天持有股票，准备卖出获得收益，取最大值
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price[i]);
            //第i天持有股票的最大利润等于第i-1天持有股票的利润或者第i-1天持有现金，并准备买入股票的收益，取最大值
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-price[i]);
        }
        //取出最后一天持有现金的利润
        return dp[len-1][0];
    }

}
