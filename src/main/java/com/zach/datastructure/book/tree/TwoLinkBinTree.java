package com.zach.datastructure.book.tree;

/**
 * 二叉链式存储结构实现二叉树
 * @param <E>
 */
public class TwoLinkBinTree<E> {
    public static class TreeNode {
        Object   data;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }


        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;

    //以默认的构造器创建二叉树
    public TwoLinkBinTree(){
        this.root = new TreeNode();
    }

    //以指定根元素创建二叉树
    public TwoLinkBinTree(E data) {
        this.root = new TreeNode(data);
    }

    //为指定节点添加子节点
    public TreeNode addNode(TreeNode parent,E data,boolean isLeft){
        if(parent == null)
            throw new RuntimeException(parent+"节点为null,无法添加子节点");

        if(isLeft && parent.left !=null)
            throw new RuntimeException(parent+"节点已有左子节点,无法添加左子节点");

        if (isLeft && parent.right !=null)
            throw new RuntimeException(parent+"节点已右子节点,无法添加右子节点");

        TreeNode newNode = new TreeNode(data);
        if(isLeft)
            parent.left = newNode;
        else
            parent.right = newNode;

        return newNode;
    }

    //判断二叉树是否为空
    public boolean empty() {
        //根据根元素判断二叉树是否为空
        return root.data == null;
    }

    //返回根节点
    public TreeNode root() {
        if(empty())
            throw new RuntimeException("树为空,无法访问根节点");

        return root;

    }

    //返回指定节点(非根节点)的父节点
    public E parent(TreeNode node){
        //对于二叉链表存储,如果要访问指定节点的父节点必须遍历二叉树
        return null;
    }

    //返回指定节点(非叶子)的左子节点
    public E leftChild(TreeNode parent){
        if(parent == null)
            throw new RuntimeException(parent+"节点为null,无子节点");

        return parent.left == null ? null : (E)parent.left.data;
    }

    //返回指定节点(非叶子)的左子节点
    public E rightChild(TreeNode parent){
        if(parent == null)
            throw new RuntimeException(parent+"节点为null,无子节点");

        return parent.right == null ? null : (E)parent.right.data;
    }

    //返回该二叉树的深度
    public int deep() {
        //获取该树的深度
        return deep(root);
    }

    //递归方法: 每棵子树的深度为其所有子树的最大深度+1
    private int deep(TreeNode node) {

        if(node == null)
            return 0;

        //没有子树
        if(node.left == null && node.right == null)
            return 1;

        else{
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);

            //记录其所有左右子树中较大的深度
            int max = leftDeep>rightDeep ? leftDeep : rightDeep;

            //返回其左右子树中较大的深度+1
            return max +1;
        }
    }

    public static void main(String[] args) {
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree<>("根节点");

        //依次添加节点
        TwoLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root(),"第二层左节点",true);
        TwoLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root(),"第二层右点",false);
        TwoLinkBinTree.TreeNode tn3 = binTree.addNode(tn2,"第三层左节点",true);
        TwoLinkBinTree.TreeNode tn4 = binTree.addNode(tn2,"第三层右节点",false);
        TwoLinkBinTree.TreeNode tn5 = binTree.addNode(tn3,"第四层左节点",true);
        System.out.println("tn2的左子节点: "+binTree.leftChild(tn2));
        System.out.println("tn2的右子节点: "+binTree.rightChild(tn2));
        System.out.println(binTree.deep());


    }
}
