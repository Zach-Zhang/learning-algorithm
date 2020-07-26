package com.zach.frequency;

import java.util.Arrays;

/**
 * @Classname JumpStep
 * @Description: 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 分析:
 * 当 n = 1 时，只有一种跳法：
 * 当 n = 2 时，有两种跳法：
 * 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。而 n-1 和 n-2 阶台阶的
 * 跳法可以看成子问题，该问题的递推公式为：
 * fn={
 * 1                n=1
 * 2                n=2
 * f(n-1) + f(n-2) n>2
 * }
 * @Date 2020/7/25 22:14
 * @Author: Zach
 * @version: V1.0
 */
public class JumpStep {

    public static void main(String[] args) {
        System.out.println(3);
    }


    public int jumpStep(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int m = 0;
        for (int i = 3; i <= n; i++) {
            m = pre1 + pre2;
            pre1 = pre2;
            pre2 = m;
        }
        return m;
    }
}
