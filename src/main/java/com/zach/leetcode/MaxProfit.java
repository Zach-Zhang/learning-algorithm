package com.zach.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] price = new  int[]{7,1,5,3,6,11};
        int[] price2 = new int[]{9,3,12,1,2,3};
        int maxProfit = calMaxProfit2(price2);
        System.out.println(maxProfit);
    }

    /**
     * 暴力解法
     * @param price
     * @return
     */
    public static int calMaxProfit(int[] price){
        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            int buy = price[i];
            for (int j = i+1; j <price.length ; j++) {
                if(buy<price[j]){
                    maxProfit = Math.max(maxProfit,price[j]-buy);
                }
            }
        }
        return maxProfit;
    }

    /**
     * 贪心思想，先记录历史的最低点，算出卖出的利润，考虑完所有的天数，即求出最大利润
     * @param price
     * @return
     */
    public static int calMaxProfit2(int[] price){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            if(price[i]<minPrice){
                minPrice=price[i];
            }else if(price[i]-minPrice>maxProfit){
                maxProfit=price[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
