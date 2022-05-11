package com.zach.second;

import com.zach.common.ListNode;

/**
 * @Description: 合并两个排序的链表
 * @Author Zach
 * @Date 2022/4/25 14:49
 * Version :1.0
 */
public class MergeListNode {
    public static void main(String[] args) {

    }

    public static ListNode recursiveMergeListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }

        if (l1.data <= l2.data) {
            l1.next = recursiveMergeListNode(l1.next, l2);
            return l1;
        } else {
            l2.next = recursiveMergeListNode(l1, l2.next);
            return l2;
        }

    }

    public static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return pre.next;
    }
}
