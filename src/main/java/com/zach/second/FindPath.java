package com.zach.second;

import com.zach.common.TreeNode;

import java.util.LinkedList;

/**
 * @Description: 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下
 * 一直到叶结点所经过的结点形成一条路径。
 * 下图的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
 * @Author Zach
 * @Date 2022/5/12 7:57
 * Version :1.0
 */
public class FindPath {
    static LinkedList<Integer> path = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> ret = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static LinkedList<LinkedList<Integer>> findPath(TreeNode root, int target) {
        recur(root, target);
        return ret;
    }

    private static void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        //路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除
        path.removeLast();
    }
}
