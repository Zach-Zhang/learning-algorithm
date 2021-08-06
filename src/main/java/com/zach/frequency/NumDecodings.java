package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，
 * 例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不
 * 同的翻译方法
 * @Author Zach
 * @Date 2021/7/1 20:22
 * Version :1.0
 */
public class NumDecodings {
    public static void main(String[] args) {
        String numbers = "12258";
        System.out.println(numDecodings(numbers));
    }

    public static int numDecodings(String number) {
        if (StringUtils.isEmpty(number)) {
            return 0;
        }
        int[] dp = new int[number.length() + 1];
        dp[0] = 1;
        dp[1] = number.charAt(0) == '0' ? 0 : 1;
        int n = number.length();
        for (int i = 2; i <= n; i++) {
            Integer one = Integer.valueOf(number.substring(i - 1, i));
            if (one != null) {
                dp[i] += dp[i - 1];
            }
            if (number.charAt(i - 2) == '0') {
                continue;
            }

            Integer two = Integer.valueOf(number.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];

    }
}
