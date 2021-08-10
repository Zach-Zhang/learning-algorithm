package com.zach.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:给定一棵二叉搜索树，请找出其中第k大的节点
 * @Author Zach
 * @Date 2021/8/10 7:38
 * Version :1.0
 */
public class TopKOfBinarySearchTree {
    final static List<Integer> treeList = new ArrayList<>();

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(4);
        ListNode childRight = new ListNode(2);
        left.right = childRight;
        root.left = left;
        root.right = right;
        int res = topKOfTree(root, 4);
        System.out.println(res);

    }

    public static int topKOfTree(ListNode root, int k) {
        if (root == null) {
            return -1;
        }
        recurPostOrder(root);
        if (k - 1 < 0 || k > treeList.size()) {
            return -1;
        }
        int size = treeList.size();
        return treeList.get(k - 1);
    }

    public static void recurPostOrder(ListNode root) {
        if (root == null) {
            return;
        }
        recurPostOrder(root.right);
        treeList.add(root.val);
        recurPostOrder(root.left);
    }

    private static class ListNode {
        int val;
        ListNode left;
        ListNode right;

        ListNode(int x) {
            val = x;
        }
    }
}
