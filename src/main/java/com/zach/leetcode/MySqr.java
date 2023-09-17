package com.zach.leetcode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqr {
    public static void main(String[] args) {
        int ret = mySqr(25);
        System.out.println(ret);
    }

    /**
     * 二分法查找
     * @param num
     * @return
     */
    public static int mySqr(int num){
        int l = 1;
        int h = num;

        while (l<=h){
            int mid = l+(h-l)/2;
            int sqr = num/mid;
            //sqr = num/sqr,在0到num之前查找sqr
            if(sqr==mid){
               return sqr;
            }else if(mid<sqr){
                //左边界右移
                l = mid+1;
            }else {
                //右边界左移
                h = mid-1;
            }
        }
        //当l>h时退出循环，因为小数部分是被抛弃的，所以应当返回h
        return h;
    }
}
