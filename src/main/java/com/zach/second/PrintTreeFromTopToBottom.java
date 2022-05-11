package com.zach.second;

import com.zach.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
 * @Author Zach
 * @Date 2022/5/7 9:04
 * Version :1.0
 */
public class PrintTreeFromTopToBottom {
    public static void main(String[] args) {

    }

    public static List<Integer> printTreeFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    continue;
                }
                int val = treeNode.val;
                ret.add(val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        return ret;
    }
}
