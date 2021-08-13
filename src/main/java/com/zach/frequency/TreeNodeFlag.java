package com.zach.frequency;

import com.zach.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author Zach
 * @Date 2021/8/13 7:49
 * Version :1.0
 */
public class TreeNodeFlag {
    private boolean isBalance = true;

    public static void main(String[] args) {
        TreeNode left3 = new TreeNode(4);

        TreeNode right3 = new TreeNode(4);

        TreeNode left2 = new TreeNode(left3, right3, 3);

        TreeNode left1 = new TreeNode(left2, new TreeNode(3), 2);

        TreeNode right1 = new TreeNode(new TreeNode(5), new TreeNode(3), 2);

        TreeNode root = new TreeNode(left1, right1, 1);
        boolean flag = treeNodeFlag(root);
        System.out.println(flag);

    }

    public static boolean treeNodeFlag(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        int leftDepth = maxDepthBFS(treeNode.getLeft());

        int rightDepth = maxDepthBFS(treeNode.getRight());

        return Math.abs(leftDepth - rightDepth) <= 1;
    }

    /**
     * 使用队列实现层序遍历,
     *
     * @param root
     * @return
     */
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.getLeft() != null) {
                    queue.add(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    queue.add(treeNode.getRight());
                }
            }
        }
        return res;
    }

    /**
     * 方法二,先序遍历递归实现
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalance;

    }

    private int height(TreeNode root) {
        if (root == null || !isBalance) {
            return 0;
        }
        int left = height(root.getLeft());
        int right = height(root.getRight());
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(left, right);
    }
}
