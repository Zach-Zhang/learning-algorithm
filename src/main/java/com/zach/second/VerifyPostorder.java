package com.zach.second;

/**
 * @Description: 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * @Author Zach
 * @Date 2022/5/9 8:16
 * Version :1.0
 */
public class VerifyPostorder {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 5};
        int[] a2 = {1,6,3,2,5};
        boolean flag = verifyPostorder(a2);
        System.out.println(flag);
    }

    public static boolean verifyPostorder(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return verifyPostorder(array, 0, array.length - 1);

    }

    private static boolean verifyPostorder(int[] array, int left, int last) {
        if (last - left <= 1) {
            return true;
        }
        int rootValue = array[last];
        int mid = left;
        //找到第一个大于根节点的节点
        while (mid < last && array[mid] <= rootValue) {
            mid++;
        }
        for (int i = mid; i < last; i++) {
            if (array[i] < rootValue) {
                return false;
            }
        }
        //左子树的范围【left,mid-1],右子树范围【mid,last-1]
        return verifyPostorder(array, left, mid - 1) && verifyPostorder(array, mid, last - 1);
    }
}
