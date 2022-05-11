package com.zach.second;

import com.zach.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 重建二叉树
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的
 * 数字
 * @Author Zach
 * @Date 2022/4/14 8:28
 * Version :1.0
 */
public class ReConstructBinaryTree {
    private static Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {

    }

    public static TreeNode reconstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i], i);
        }
        return reconstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * 递归重建二叉树
     *
     * @param pre  前序遍历的数组
     * @param preL 前序遍历的左子树起点
     * @param preR 前序遍历的右子树终点
     * @param inL  中序遍历的起点
     * @return
     */
    private static TreeNode reconstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        //表示已经越过叶节点
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer rootIndex = indexMap.get(root.getVal());
        //左子树的长度
        int leftSize = rootIndex - inL;
        //左子树，在前序遍历的位置【preL+1,preL+lefSize】
        root.setLeft(reconstructBinaryTree(pre, preL + 1, preL + leftSize, inL));
        //右子树 在前序遍历的位置【preL+leftSize+1,preR】
        root.setRight(reconstructBinaryTree(pre, preL + leftSize + 1, preR, inL + leftSize + 1));
        return root;
    }
}
