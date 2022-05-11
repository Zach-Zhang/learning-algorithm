package com.zach.second;

import com.zach.common.TreeNode;

/**
 * @Description: 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子
 * 结点，同时包含指向父结点的指针
 * @Author Zach
 * @Date 2022/4/19 8:37
 * Version :1.0
 */
public class TreeLinkNode {
    public static void main(String[] args) {

    }

    public static TreeNode getNextNode(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        //存在右子树
        if (pNode.right != null) {
            TreeNode rightNode = pNode.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            return rightNode;
        } else {
            while (pNode.next != null) {
                TreeNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }

        }
        return null;
    }
}
