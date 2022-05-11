package com.zach.second;

import com.zach.common.ListNode;

/**
 * @Description: 反转链表
 * @Author Zach
 * @Date 2022/4/17 8:56
 * Version :1.0
 */
public class ReverseListNode {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseListNode(next);
        next.next = head;
        return newHead;
    }

    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode2(ListNode head) {
        ListNode pre = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = pre.next;
            //指针右移
            pre.next = head;
            head = next;
        }
        return pre.next;
    }

    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            //指针右移
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
