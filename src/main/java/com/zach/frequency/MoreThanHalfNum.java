package com.zach.frequency;

/**
 * @Description:数组中出现次数超过一半的数字 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @Author Zach
 * @Date 2021/3/18 8:05
 * Version :1.0
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {

    }

    /**
     * 摩尔投票法: 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ，
     * @param array
     * @return
     */
    public static int moreThanHalfNum(int[] array) {
        int vote = 0, x = 0, count = 0;
        for (int num : array) {
            if (vote == 0) {
                //假设当前num为众数
                x = num;
            }
            //当x==num则自增1否则自减1
            vote += x == num ? 1 : -1;
        }

        //验证x是否为众数
        for (int i : array) {
            if (i == x) {
                count++;
            }
        }
        //若x的数量超过数组长度的一半,则为众数,否则没有众数返回0
        return count > array.length / 2 ? x : 0;

    }
}
