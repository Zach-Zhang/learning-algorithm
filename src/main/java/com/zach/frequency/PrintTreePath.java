package com.zach.frequency;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树中和为某一值的路径;输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下
 * 一直到叶结点所经过的结点形成一条路径
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11 13  4
 * / \    /\
 * 7  2  5  1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * @Author Zach
 * @Date 2021/1/5 22:25
 * Version :1.0
 */
public class PrintTreePath {
    private final static List<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        TreeNode l2 = new TreeNode(11);

        TreeNode l3 = new TreeNode(7);
        TreeNode r3 = new TreeNode(2);

        TreeNode treeNode = new TreeNode(13);
        TreeNode t4 = new TreeNode(4);

        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);

        l2.left = l3;
        l2.right = r3;
        t4.left = t5;
        t4.right = t1;

        left.left = l2;
        right.left = treeNode;
        right.right = t4;

        root.left = left;
        root.right = right;
        PrintTreePath printTreePath = new PrintTreePath();
        printTreePath.printTreePath(root, 22);
        System.out.println(result);

    }

    public List<List<Integer>> printTreePath(TreeNode root, int target) {
        recur(root, target);
        return result;
    }

    //回溯算法+先序遍历+递归
    private void recur(TreeNode root, int target) {

        if (root == null) {
            return;
        }
        //记录节点路径
        path.add(root.val);
        target -= root.val;
        //路径的节点值的和等于target,root为叶子节点
        if (target == 0 && root.left == null & root.right == null) {
            result.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        //回溯到上一个节点,删除当前节点
        path.removeLast();
    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;


        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
