package com.zach.frequency;

/**
 * @Description:二叉搜索树的后序遍历序列 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相
 * 同。
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * @Author Zach
 * @Date 2021/1/3 18:10
 * Version :1.0
 */
public class VerifySequenceOfBST {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5};
        System.out.println(verifySequenceOfBST(arr));
    }

    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private static boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int curIndex = first;
        //左子树比根节点小,找到第一个比rootVal大的子节点
        while (curIndex < last && sequence[curIndex] <= rootVal) {
            curIndex++;
        }
        //右子树比跟节点大
        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        //递归比较左右子树区间的值
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);
    }
}
