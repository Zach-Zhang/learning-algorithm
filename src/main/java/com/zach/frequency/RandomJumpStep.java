package com.zach.frequency;

import java.util.Arrays;

/**
 * @Classname RandomJumpStep
 * @Description:一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种
 * 跳法。
 * @Date 2020/7/26 10:02
 * @Author: Zach
 * @version: V1.0
 */
public class RandomJumpStep {
    public static void main(String[] args) {
        System.out.println(mehtodSecond(3));
        System.out.println(mehtodSecond(3));

    }

    /**
     * @return {@link int}
     * @Author Zach
     * @Description n级台阶, 可以一次跳n级, 也可以跳f(n - 1)级, 一次类推f(n)=f(n-1)+f(n-2)+...+1,可以使用循环+递归求解,但是很好资源,第二种思路就是
     * 使用数组dp对每一台阶的方法和保存下来，从而节约时间。把每个f(n)的值存放在一个数组中的一个元素中，从第二个元素开始，每个dp[i]都赋值为前 i 项的和，使用for循环即可实现
     * @Date 10:25 2020/7/26
     * @Param [n]
     **/
    public static int methodOne(int target) {
        if (target <= 2) {
            return target;
        }
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    /**
     * @return {@link int}
     * @Author Zach
     * @Description 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     * 综上可得: f(n) - f(n-1) = f(n-1)
     * 即f(n)=2*f(n-1),这是一个等比数列
     * @Date 10:31 2020/7/26
     * @Param [target]
     **/
    public static int mehtodSecond(int target) {
        return (int) (Math.pow(2, target - 1));
    }
}
