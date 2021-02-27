package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * @Author Zach
 * @Date 2021/2/27 11:35
 * Version :1.0
 */
public class SerializeTree {
    public static void main(String[] args) {

    }

    /**
     * BFS 序列化
     *
     * @param root 根节点
     * @return
     */
    public String serializeBFS(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        //删除掉最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }


    /**
     * BFS反序列化
     *
     * @param data 序列化后的字符串
     * @return
     */
    public TreeNode deserialize(String data) {
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            i++;
            if (!values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    /**
     * DFS序列化
     *
     * @param root
     * @return
     */
    public String serializeDFS(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serializeDFS(root.left) + "," + serializeDFS(root.right);
    }

    /**
     * DFS反序列化
     *
     * @param data
     * @return
     */
    public TreeNode deserializeDFS(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private Integer val;

        public TreeNode() {
        }

        public TreeNode(Integer val) {
            this.val = val;
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
