package com.zach.frequency;

/**
 * @Description:我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * @Author Zach
 * @Date 2021/7/20 7:48
 * Version :1.0
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(7));
    }

    /**
     *
     * @param n
     * @return
     */
    public static int getUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int j2 = 0, j3 = 0, j5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int r2 = dp[j2]*2, r3 = dp[j3] * 3, r5 = dp[j5] * 5;
            dp[i] = Math.min(r2, Math.min(r3, r5));
            if (dp[i] == r2) {
                j2++;
            }
            if (dp[i] == r3) {
                j3++;
            }
            if (dp[i] == r5) {
                j5++;
            }
        }

        return dp[n - 1];
    }
}
