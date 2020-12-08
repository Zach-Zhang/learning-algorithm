package com.zach.frequency;

import java.util.Stack;

/**
 * Created by Zach
 * Date :2020/12/8 10:52
 * Description : 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 * 4
 * /  \
 * 2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 * 4
 * /  \
 * 7   2
 * / \  / \
 * 9  6 3 1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * Version :1.0
 */
public class MirrorTree {
    public static void main(String[] args) {

    }

    /**
     * @return com.zach.frequency.MirrorTree.TreeNode
     * @Description: 递归实现遍历
     * @Date 11:53 2020/12/8
     * @Param [root]
     **/
    public static TreeNode recurMirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //这一步是递归的关键,高度抽象
        root.left = recurMirrorTree(root.right);
        root.right = recurMirrorTree(root.left);
        return root;
    }
    /**
     * @Description:  利用栈后进先出的特点,遍历所有的节点,
     * @Date 12:06 2020/12/8
     * @Param [root]
     * @return com.zach.frequency.MirrorTree.TreeNode
     **/
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
        }
        return root;
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
