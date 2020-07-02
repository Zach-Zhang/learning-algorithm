package com.zach.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ReconstructBinaryTree
 * @Description: 重建二叉树;根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的
 * 数字。
 * @Date 2020/6/29 20:42
 * @Author: Zach
 * @version: V1.0
 */
public class ReconstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = reconstructBinaryTree(pre, inorder);
        System.out.println(treeNode);
    }

    private static Map<Integer, Integer> indexForOrders = new HashMap<>();

    public static TreeNode reconstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForOrders.put(in[i], i);
        }
        return reconstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reconstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndex = indexForOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reconstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reconstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
