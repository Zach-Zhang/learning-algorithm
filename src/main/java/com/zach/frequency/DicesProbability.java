package com.zach.frequency;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description:
 * @Author Zach
 * @Date 2021/11/22 8:27
 * Version :1.0
 */
public class DicesProbability {
    public static void main(String[] args) {
        double[] doubles = dicesProbability(2);
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);

        }
       // System.out.println(Collections.singletonList(doubles));
    }

    public static double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
