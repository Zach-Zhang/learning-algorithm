package com.zach.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author Zach
 * @Date 2021/2/16 22:52
 * Version :1.0
 */
public class CopyRandomList {
    public static void main(String[] args) {

    }

    /**
     * 通过哈希映射原链表节点与新链表节点,再遍历构建新链表各节点的 next 和 random 引用指向即可。
     * 时间复杂度: 两轮遍历链表,使用O(N)的时间
     * 空间复杂度: O(N),哈希表使用线性大小的额外空间
     *
     * @param head
     * @return
     */
    public LinkNode copyRandomListByMap(LinkNode head) {
        if (head == null) {
            return null;
        }
        Map<LinkNode, LinkNode> nodeMap = new HashMap<>();
        LinkNode cur = head;
        //构建原链表节点与新链表节点的映射
        while (cur != null) {
            nodeMap.put(cur, new LinkNode(cur.val));
            cur = cur.next;
        }
        LinkNode pre = head;
        //查找对应的next和random引用即可
        while (pre != null) {
            //不能nodeMap.get(pre).next = pre.next;因为这样就指向了原链表的节点,而题目是要复制链表,所以应该指向新的链表next
            nodeMap.get(pre).next = nodeMap.get(pre.next);
            nodeMap.get(pre).random = nodeMap.get(pre.random);
            pre = pre.next;
        }
        //返回新链表的头节点
        return nodeMap.get(head);
    }

    /**
     * 方法二: 拼接链表+拆分
     * 考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的
     * random 指向节点。
     * 时间复杂度:O(N),三轮遍历
     * 空间复杂度: O(1) 节点引用变量使用常数大小的额外空间
     *
     * @param head
     * @return
     */
    public LinkNode copyRandomList(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode cur = head;
        //复制节点,并拼接链表
        while (cur != null) {
            LinkNode temp = new LinkNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //构建各个新节点的random指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分两个链表
        cur = head.next;
        LinkNode pre = head, res = head.next;
        //从新链表的头节点开始遍历
        while (cur.next != null) {
            //原链表
            pre.next = pre.next.next;
            //新建的链表,即复制的节点
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        //单独处理原链表的尾结点
        pre.next = null;
        //返回新链表的头节点
        return res;
    }

    public class LinkNode {
        private int val;
        private LinkNode next;
        private LinkNode random;

        public LinkNode(int val) {
            this.val = val;
        }

        public LinkNode() {
        }

        public LinkNode(int val, LinkNode next, LinkNode random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
