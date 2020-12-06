package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/12/6 11:59
 * Description :
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * Version :1.0
 */
public class IsSubTree {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;
        A.left = left1;
        A.right = right1;
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        System.out.println(isSubTree(A, B));
    }

    /**
     * @return boolean
     * @Description: 判断是否为子树结构, 对A递归先序遍历
     * @Date 12:19 2020/12/6
     * @Param [A, B]
     **/
    private static boolean isSubTree(TreeNode A, TreeNode B) {
        return (A != null && B != null) && recur(A, B) || isSubTree(A.left, B) || isSubTree(A.right, B);
    }

    /**
     * @return boolean
     * @Description 递归判断
     * @Date 12:18 2020/12/6
     * @Param [A, B]
     **/
    private static boolean recur(TreeNode A, TreeNode B) {
        //说明B树完成匹配
        if (B == null) {
            return true;
        }
        System.out.println("A:" + A);
        System.out.println("================");
        System.out.println("B:" + B);
        System.out.println("================");
        //A==null,说明已经越过树 A叶子节点，即匹配失败，返回 false,A的值与B不相等,则为false ；
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
