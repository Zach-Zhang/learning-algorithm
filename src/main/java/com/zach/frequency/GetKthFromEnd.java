package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/11/8 15:09
 * Description :
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * Version :1.0
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
    }

    /**
     * @return com.zach.frequency.GetKthFromEnd.ListNode
     * @Author
     * @Description 方法一直接遍历一遍获取链表的长度n, 然后再走n-k步就可以了
     * @Date 16:09 2020/11/8
     * @Param [head, k]
     **/
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head;
        int count = 0;
        while (preNode.next != null) {
            count++;
            preNode = preNode.next;
        }
        if (count < k) {
            return null;
        }
        if (count == k) {
            return preNode;
        }
        int len = count - k;
        ListNode node = head;
        while (len > 0) {
            node = node.next;
            len--;
        }
        return node;
    }

    /**
     * @return com.zach.frequency.GetKthFromEnd.ListNode
     * @Author Zach
     * @Description 使用双指针则可以不用统计链表长度。
     * 初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head 。
     * 构建双指针距离： 前指针 former 先向前走 kk 步（结束后，双指针 former 和 latter 间相距 kk 步）。
     * 双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为 k-1k−1，即 latter 指向倒数第 kk 个节点）。
     * 返回值： 返回 latter 即可。
     * @Date 16:13 2020/11/8
     * @Param [head, k]
     **/
    public static ListNode getKthFromEndBySecond(ListNode head, int k) {
        ListNode preNode = head, lastNode = head;
        int count = 0;
        while (preNode != null) {
            if (count >= k) {
                lastNode = lastNode.next;
            }
            preNode = preNode.next;
            count++;
        }
        return lastNode;
    }

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(ListNode next, int data) {
            this.next = next;
            this.data = data;
        }

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode() {
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
