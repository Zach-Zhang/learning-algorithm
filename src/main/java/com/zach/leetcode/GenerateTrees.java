package com.zach.leetcode;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
  给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
  <p>
  输入：n = 3
  输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
  <p>
  示例 2：
  <p>
  输入：n = 1
  输出：[[1]]
*/
public class GenerateTrees {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = new GenerateTrees().generateTree(3);
        System.out.println(JSON.toJSONString(treeNodes));
    }

    public  List<TreeNode> generateTree(int n) {
        if (n < 1) {
            return new ArrayList<>(0);
        }
        return this.generateSubtrees(1, n);
    }

    /**
      回溯法
      枚举根节点的值，根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树
     
      @param left
      @param right
      @return
     */
    private  List<TreeNode> generateDfs(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        //枚举根节点的值
        for (int i = left; i <= right; ++i) {
            //左子树，假如i是根节点，左子树节点值集合[left,i-1]
            List<TreeNode> leftTreeNode = generateDfs(left, i - 1);
            //右子树,假如i是根节点，右子树节点集合[i+1,right]
            List<TreeNode> rightTreeNode = generateDfs(i + 1, right);
            //合并左右子树
            for (TreeNode leftNode : leftTreeNode) {
                for (TreeNode rightNode : rightTreeNode) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }

        return res;
    }

    private  List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null);
            return res;
        }

        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public  class TreeNode {
           int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
