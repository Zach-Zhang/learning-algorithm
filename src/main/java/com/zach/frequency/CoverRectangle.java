package com.zach.frequency;

/**
 * @Classname CoverRectangle
 * @Description: 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩
 * 形，总共有多少种方法？
 * @Date 2020/7/25 21:49
 * @Author: Zach
 * @version: V1.0
 */
public class CoverRectangle {
    public static void main(String[] args) {
        System.out.println(converRectangle(4));
    }

    /**
     * @return {@link int}
     * @Author Zach
     * @Description 分析如下:
     * n=1 m=1;
     * n=2 m=2;
     * n=3 m = 3;
     * 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2)
     * 的矩形。而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。该问题的递推公式如下：
     * fn={
     * 1                n=1
     * 2                n=2
     * f(n-1) + f(n-2) n>2
     * }
     * @Date 21:52 2020/7/25
     * @Param [n]
     **/
    public static int converRectangle(int n) {
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
