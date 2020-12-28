package com.zach.frequency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Zach
 * Date :2020/12/28 21:35
 * Description :从上往下打印二叉树 同一层的节点按照从左到右的顺序打印。
 * 给定二叉树: [3,9,20,null,null,15,7]
 * 返回 [3,9,20,15,7]
 * Version :1.0
 */
public class PrintFromTopToBottom {
    public static void main(String[] args) {

    }
    /**
     * @Description: 借助队列
     * @Date 21:54 2020/12/28
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public static List<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        //队列装树的节点
        Queue<TreeNode> queue = new LinkedList();
        //集合装节点中的值
        List<Integer> dataList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode treeNode = queue.poll();
            while (size-- > 0) {
                //空节点直接跳过
                if (treeNode == null) {
                    continue;
                }
                dataList.add(treeNode.val);
                //加入左子节点
                queue.add(treeNode.left);
                //加入右子节点
                queue.add(treeNode.right);

            }
        }
        return dataList;
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
