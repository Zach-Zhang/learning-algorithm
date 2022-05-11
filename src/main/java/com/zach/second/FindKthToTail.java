package com.zach.second;

import com.zach.common.ListNode;

/**
 * @Description: 链表中倒数第 K 个结点
 * @Author Zach
 * @Date 2022/4/23 9:25
 * Version :1.0
 */
public class FindKthToTail {

    public static void main(String[] args) {

    }

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        //第p1指针先走k步
        ListNode p1 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        //表示k的大小超过了链表的长度
        if (k > 0) {
            return null;
        }
        ListNode p2 = head;
        //p2指针从头结点开始，与p1指针同时向右移动，当p1到达尾结点时，p2指向倒数第k个节点
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
