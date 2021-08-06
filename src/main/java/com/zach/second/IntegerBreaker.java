package com.zach.second;

/**
 * @Description:剪绳子,把一根绳子剪成多段，并且使得每段的长度乘积最大 n = 2
 * return 1 (2 = 1 + 1)
 * n = 10
 * return 36 (10 = 3 + 3 + 4)
 * @Author Zach
 * @Date 2021/6/14 21:06
 * Version :1.0
 */
public class IntegerBreaker {
    public static void main(String[] args) {
        System.out.println(integerBreakByDP(10));
        System.out.println(integerBreakByGreedy(10));
    }

    /**
     * 贪心算法,求出局部最优解,尽量剪出长度为3或者2的,乘积最大
     */
    public static int integerBreakByGreedy(int n) {
        //绳子是要截断的,所以n=1时,乘机取整是0
        if (n <= 3) {
            return n - 1;
        }
        //尽可能减长度为3的绳子
        int timeOf3 = n / 3;
        //当长度不够3,拿出长度1,组成长度为2
        if (n - timeOf3 * 3 == 1) {
            timeOf3--;
        }
        //剪出长度为2的绳子
        int timeOf2 = (n - timeOf3 * 3) / 2;
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }

    /**
     * 动态规划,先剪出长度为1的
     */
    public static int integerBreakByDP(int n) {
        //dp数组记录从0-n长度的绳子减掉后的最大乘积
        int[] dp = new int[n + 1];
        //先减掉第一段
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //j*(i-j)表示减掉长度j之后,后面的绳子就不减了
                //dp[j] * (i - j)表示减掉j长度后,剩余的长度的绳子还需要继续减
                dp[i] =  Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}
