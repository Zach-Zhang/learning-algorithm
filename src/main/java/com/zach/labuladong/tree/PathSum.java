package com.zach.labuladong.tree;
import java.util.HashMap;
import java.util.Map;

/**
 * Given the `root` of a binary tree and an integer `targetSum`, return *the number of paths where the sum of the values along the path equals* `targetSum`.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 *
 * **Example 2:**
 *
 * ```
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode right = new TreeNode(-3);
        TreeNode r1 = new TreeNode(11);
        right.setRight(r1);
        TreeNode left = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(1);
        r2.setRight(r3);
        left.setRight(r2);
        left.setLeft(l1);
        TreeNode l2 = new TreeNode(3);
        TreeNode r4 = new TreeNode(-2);
        l1.setLeft(l2);
        l1.setRight(r4);
        root.setRight(right);
        root.setLeft(left);
        int result = pathSum(root, 8);
        System.out.println(result);
        int result2 = pathSum2(root, 8);
        System.out.println(result2);


    }

    /**
     * 暴力解法，双重递归
     * @param root
     * @param targetSum
     * @return
     */
    public  static int pathSum(TreeNode root,int targetSum){
        if(root==null){
            return 0;
        }
        // 以当前节点为起点路径数+左子树的路径数+右子树路径数
        return calcSumFrom(root,targetSum)+calcSumFrom(root.left,targetSum)+calcSumFrom(root.right,targetSum);

    }

    public  static int pathSum2(TreeNode root,int targetSum){
        Map<Long,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L,1);
        return dfs(root,0,targetSum,prefixSumMap);

    }

    /**
     * 前缀和方法的本质：
     *
     * 将"寻找路径段"问题转换为"查找历史前缀和"问题
     * 利用数学关系：路径和 = 当前前缀和 - 起始点前缀和
     *
     * 设从根到节点A的前缀和为prefixA，从根到节点B的前缀和为prefixB
     * 则从A的下一个节点到B的路径和 = prefixB - prefixA
     *
     * 要找路径和为targetSum的路径：
     * prefixB - prefixA = targetSum
     * 变换得：prefixA = prefixB - targetSum
     * @param root
     * @param currentSum
     * @param targetSum
     * @param prefixSumCount
     * @return
     */
    public static int dfs(TreeNode root,long currentSum,int targetSum,Map<Long,Integer> prefixSumCount){
        if(root==null){
            return 0;
        }
        //当前路径前缀和
        currentSum += root.val;
        // 数学公式：currentSum - prefixSum = targetSum
        // 变换得：prefixSum = currentSum - targetSum
        long needPrefixSum = currentSum - targetSum;
        int pathCount = prefixSumCount.getOrDefault(needPrefixSum,0);
        //将当前前缀和加入哈希表，为后续节点提供查询依据
        prefixSumCount.put(currentSum,prefixSumCount.getOrDefault(currentSum,0)+1);
        //递归处理左右子树，累加路径数量
        pathCount += dfs(root.left,currentSum,targetSum,prefixSumCount);
        pathCount += dfs(root.right,currentSum,targetSum,prefixSumCount);
        //回溯移除当前节点的前缀和记录,确保哈希表只包含当前路径的前缀和
        prefixSumCount.put(currentSum,prefixSumCount.get(currentSum)-1);
        if(prefixSumCount.get(currentSum)==0){
            prefixSumCount.remove(currentSum);
        }
        return pathCount;

    }

    private static int calcSumFrom(TreeNode node,long targetSum){
        if(node == null){
            return 0;
        }
        int count = 0;
        //如果当前节点值等于目标和，找到一条路径
        if(node.val==targetSum){
            count++;
        }
        count += calcSumFrom(node.left,targetSum-node.val);
        count += calcSumFrom(node.right,targetSum-node.val);
        return count;

    }

    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
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
    }
}
