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

    /**
     * 分治算法,递推子树
     *
     * @param pre  先序遍历的数组
     * @param preL 先序遍历的根节点索引
     * @param preR 递归树的右边界，即数组右边界
     * @param inL  递归树的左边界,即数组的左边界
     * @return
     */
    private static TreeNode reconstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        //preL大于preR表明已经越过叶子节点,相等则表示就是自己
        if (preL > preR) {
            return null;
        }
        //先序遍历中的根节点
        TreeNode root = new TreeNode(pre[preL]);
        //找到根节点在中序遍历中的索引值
        Integer inIndex = indexForOrders.get(root.val);
        //
        int leftTreeSize = inIndex - inL;
        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.left = reconstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        //由根节点在中序遍历的inIndex 区分成2段,inIndex 就是根
        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量,左边界是=根节点+1,右边界是先序遍历的右边界索引,
        root.right = reconstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inIndex + 1);
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
