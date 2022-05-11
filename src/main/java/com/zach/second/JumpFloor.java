package com.zach.second;

/**
 * @Description: 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种
 * 跳法
 * @Author Zach
 * @Date 2022/4/16 21:04
 * Version :1.0
 */
public class JumpFloor {
    public static void main(String[] args) {

    }

    public static int jumpFloor(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[n - 1];
    }

    public static int jumpFloor2(int n) {
        return (int) Math.pow(2, n - 1);
    }
}
