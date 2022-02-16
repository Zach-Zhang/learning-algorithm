package com.zach.frequency;

/**
 * @author Zhangshengzhi
 * @version 1.0.0
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @createTime 2022年02月16日 11:30:00
 */
public class LowestCommonAncestor {
    private static TreeNode rest;

    public static void main(String[] args) {

    }

    /**
     * 方法一,递归
     * 根据公共祖先的定义,复合公共祖先的条件
     * 假设fx表示节点x的子节点中是否包含p或q,包含true,不包含为false
     * flson&&frson||((x==p||x==q)&&flson||frson);
     * 树的高度是从下往上数,树的深度是从上往下数
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return rest;
    }

    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftFlag = dfs(root.left, p, q);
        boolean rightFlag = dfs(root.right, p, q);
        if (leftFlag && rightFlag || (root.val == p.val || root.val == q.val && (leftFlag || rightFlag))) {
            rest = root;
        }
        //判断是否是左子树或者右子树
        return leftFlag || rightFlag || (root.val == p.val || root.val == q.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
