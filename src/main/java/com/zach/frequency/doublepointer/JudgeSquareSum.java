package com.zach.frequency.doublepointer;

/**
 * @Description:两数平方的和
 * @Author Zach
 * @Date 2022/2/19 9:18
 * Version :1.0
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        boolean flag = judgeSquareSum(23);
        System.out.println(flag);
        double sqrt = Math.sqrt(4);
        System.out.println(sqrt);
    }

    public static boolean judgeSquareSum(int num) {
        if (num <= 0) {
            return false;
        }
        //用long，防止int类型会溢出
        long i = 0;
        //无需枚举完所有的值，只需要枚举到num开根号的值即可
        long j = (long) Math.sqrt(num);

        while (i <= j) {
            long rest = i * i + j * j;
            if (rest < num) {
                i++;
            } else if (rest > num) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
