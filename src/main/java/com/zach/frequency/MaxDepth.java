package com.zach.frequency;

import com.zach.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:二叉树的深度
 * @Author Zach
 * @Date 2021/8/12 7:54
 * Version :1.0
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(new TreeNode(4), new TreeNode(5), 2);
        TreeNode right = new TreeNode(new TreeNode(6), new TreeNode(7), 3);
        root.setLeft(left);
        root.setRight(right);
        System.out.println(maxDepthDFS(root));
        System.out.println(maxDepthBFS(root));
    }

    /**
     * 后续遍历,此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1。
     *
     * @param root
     * @return
     */
    public static int maxDepthDFS(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepthDFS(root.getLeft()), maxDepthDFS(root.getRight())) + 1;
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
}
