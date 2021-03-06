package com.zach.frequency;

/**
 * 剪绳子,把一根绳子剪成多段，并且使得每段的长度乘积最大,
 * 给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * * 时得到最大的乘积18。
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(intergerBreak(n));
    }

    /**
     * 动态规划:
     * 对于的正整数 n，当 n≥2 时，可以拆分成至少两个正整数的和。令 k 是拆分出的第一个正整数，
     * 则剩下的部分是 n−k，n−k 可以不继续拆分，或者继续拆分成至少两个正整数的和。
     * 由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
     * 创建数组 dp，其中 dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积。特别地，0 不是正整数，1 是最小的正整数，
     * 0 和 1 都不能拆分，因此 dp[0]=dp[1]=0
     *
     * 当 i >=2 时，假设对正整数 i 拆分出的第一个正整数是 j（1<=j<i），则有以下两种方案：
     *
     * 将 i 拆分成 j 和 i−j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j* (i-j)；
     *
     * 将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j *dp[i−j]。
     *
     * 因此，当 j固定时，有 dp[i]=max(j*dp[(i-j)],j*(i-j))由于 j的取值范围是 1 到 i-1，需要遍历所有的 j 得到 dp[i]的最大值
     * 最终得到的dp[n]的值即为将正整数 n 拆分成至少两个正整数的和之后，这些正整数的最大乘积。
     *复杂度分析
     *
     * 时间复杂度：O(n^2)O(n^2)，其中 n 是给定的正整数。对于从 2 到 n 的每一个整数都要计算对应的 dp 值，
     * 计算一个整数对应的 dp 值需要 O(n) 的时间复杂度，因此总时间复杂度是 O(n^2))。
     *
     * 空间复杂度：O(n)，其中 n 是给定的正整数。创建一个数组 dp，其长度为 n+1。
     */
    public static int intergerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int maxNum = 0;
            for (int j = 1; j < i; j++) {
                maxNum = Math.max(maxNum, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = maxNum;
        }
        return dp[n];
    }

    /**
     * 动态规划的优化:
     * 经过数据推导,尽可能将绳子以长度 33 等分为多段时，乘积最大。
     * 切分规则:
     * 最优： 33 。把绳子尽可能切为多个长度为 33 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
     * 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1+1 。
     * 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 13+1 替换为 2 + 2+2，因为 2 \times 2 > 3 \times 12×2>3×1。
     *
     * 时间复杂度 O(1)O(1) ： 仅有求整、求余、次方运算。
     * 求整和求余运算：资料提到不超过机器数的整数可以看作是 O(1)O(1) ；
     * 幂运算：查阅资料，提到浮点取幂为 O(1)O(1) 。
     * 空间复杂度 O(1)O(1) ： 变量 a 和 b 使用常数大小额外空间。
     */
    public static int cuttingRope(int n) {
        //n<3,因为按照规则,必须剪出n>1段,所以返回n-1
        if (n <= 3) {
            return n - 1;
        }
        //
        int a = n / 3;
        //余数部分
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, a);
        }
        //mod=1时,要将一个1+3转换成2+2,因为2*2>1*3
        if (mod == 1) {
            a -= 1;
            return (int) Math.pow(3, a) * 4;
        }
        //mod=2时,返回3^a*2
        return (int) Math.pow(3, a) * 2;
    }
}
