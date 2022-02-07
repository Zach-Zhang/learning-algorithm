package com.zach.frequency;

/**
 * @Description:
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 * @Author Zach
 * @Date 2022/2/7 9:05
 * Version :1.0
 */
public class CalSum {
    public static void main(String[] args) {
        int count = calSum(3);
        System.out.println(count);
    }

    /**
     * 递归 f(n) = n+f(n-1),临界条件就是n>0
     *
     * @param num
     * @return
     */
    public static int calSum(int num) {
        boolean flag = num > 0 && (num += calSum(num - 1)) > 0;
        return num;
    }
}
