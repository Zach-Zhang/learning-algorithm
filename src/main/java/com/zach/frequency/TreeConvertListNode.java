package com.zach.frequency;

/**
 * @Description:二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * @Author Zach
 * @Date 2021/2/19 21:15
 * Version :1.0
 */
public class TreeConvertListNode {
    private TreeNode pre;
    //头结点
    private TreeNode head;

    public static void main(String[] args) {

    }

    public TreeNode treeConvertListNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        //中序遍历
        dfsTreeNode(root);
        ////全部迭代完成后，pre指向双向链表中的尾节点,它的后继节点是头结点
        pre.right = head;
        //头节点的前驱节点是双向链表的尾结点
        head.left = pre;
        return head;

    }

    /**
     * 中序遍历
     *
     * @param cur
     */
    public void dfsTreeNode(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfsTreeNode(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,
        if (pre != null) {
            //pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作
            pre.right = cur;
        } else {
            //当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点,head最终指向的是最左边的叶子节点
            head = cur;
        }
        //当前节点的前驱节点
        cur.left = pre;
        //pre指向当前节点
        pre = cur;
        dfsTreeNode(cur.right);

    }

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private Integer val;

        public TreeNode() {
        }

        public TreeNode(TreeNode left, TreeNode right, Integer val) {
            this.left = left;
            this.right = right;
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

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }
}
