package com.zach.frequency;

/**
 * @Classname TreeLinkNode
 * @Description:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。 注意，树中的结点不仅包含左右子 结点，同时包含指向父结点的指针。
 * 分析:
 * 图片地址: src/main/resources/二叉树.png
 * （1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
 * <p>
 * （2） 若该节点不存在右子树：这时分两种情况：
 * <p>
 * 2.1 该节点为父节点的左子节点，则下一个节点为其父节点（如图节点 D ）
 * <p>
 * 2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，
 * 则该节点的父节点下一个节点（如图节点 I ，沿着父节点一直向上查找找到 B
 * （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）。
 *
 * @Date 2020/7/2 11:28
 * @Author: Zach
 * @version: V1.0
 */
public class TreeLinkNode {
    private int val;
    private TreeLinkNode left;
    private TreeLinkNode right;
    private TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        //当前节点存在右子树,则找右子树中的最左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            //当前节点不存在右子树,则向上找第一个左链接指向的树包含该节点的祖先节点。
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

}

