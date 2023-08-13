package com.zach.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节
 * 点），返回结果为复制后复杂链表的 head。
 * @Author Zach
 * @Date 2022/5/21 8:49
 * Version :1.0
 */
public class CopyListNode {
    private static Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

    public static void main(String[] args) {

    }

    public static RandomListNode copyListNode(RandomListNode head) {
        if (head == null) {
            return null;
        }
        if (!nodeMap.containsKey(head)) {
            RandomListNode newNode = new RandomListNode(head.val);
            nodeMap.put(head, newNode);
            newNode.next = copyListNode(head.next);
            newNode.random = copyListNode(head.random);
        }
        return nodeMap.get(head);
    }

    public static class RandomListNode {
        private RandomListNode next;
        private RandomListNode random;
        private Integer val;

        public RandomListNode(RandomListNode next, RandomListNode random, Integer val) {
            this.next = next;
            this.random = random;
            this.val = val;
        }

        public RandomListNode() {
        }

        public RandomListNode(Integer val) {
            this.val = val;
        }
    }
}
