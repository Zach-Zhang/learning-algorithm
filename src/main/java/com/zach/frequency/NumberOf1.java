package com.zach.frequency;

/**
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class NumberOf1 {
    public static void main(String[] args) {
        int i = method1(7);
        int j = method2(3);
        System.out.println(i);
        System.out.println(j);
    }

    /**
     * 使用位掩码来检查数字的第i位,任何数字与1(0000 0000 0000 0000 0000 0000 0000 0001)
     * 做与运算,都将获得这个数字的最低位,检查下一位时,将掩码左移一位,0000 0000 0000 0000 0000 0000 0000 0010
     * 重复这个过程,就可以统计出二进制中1的个数
     * @param n
     * @return
     */
    public static int method1(int n) {
        int mask = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            //左移一位
            mask <<= 1;
        }
        return sum;
    }

    /**
     * 对于任意数字n, 与n-1做与运算,都会把最后一位变成0,并保持其他位不变,可以举例,4&3=0,
     *
     * @param n
     * @return
     */
    public static int method2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }


}
