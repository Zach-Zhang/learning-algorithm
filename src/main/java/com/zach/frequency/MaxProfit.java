package com.zach.frequency;

/**
 * @Description: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @Author Zach
 * @Date 2022/2/5 10:59
 * Version :1.0
 */
public class MaxProfit {
    public static void main(String[] args) {

    }

    /**
     * 暴力求解法,先找到最小的买入价格,再从后续的日期价格中找出最大的卖出价格
     *
     * @param price
     * @return
     */
    public static int maxProfit(int[] price) {
        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length - 1; j++) {
                maxProfit = Math.max(price[j] - price[i], maxProfit);
            }
        }
        return maxProfit;
    }

    /**
     * 找到最低的买入价格,然后每次计算最大的利润,遍历一遍之后,即可找到最大的的利润,贪心思想
     * @param price
     * @return
     */
    public static int maxProfit2(int[] price) {
        int minPrice = price[0];
        int maxProfit = 0;
        for (int i = 1; i < price.length; i++) {

            if (price[i] < minPrice) {
                minPrice = price[i];
            } else if (maxProfit < price[i] - minPrice) {
                maxProfit = price[i] - minPrice;
            }

        }
        return maxProfit;
    }
}
