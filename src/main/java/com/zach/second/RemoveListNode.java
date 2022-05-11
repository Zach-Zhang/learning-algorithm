package com.zach.second;

import com.zach.common.ListNode;

/**
 * @Description: 在 O(1) 时间内删除链表节点
 * @Author Zach
 * @Date 2022/4/21 8:47
 * Version :1.0
 */
public class RemoveListNode {
    public static void main(String[] args) {

    }

    public static ListNode removeNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        //要删除的节点不是尾结点
        if (tobeDelete.next != null) {
            ListNode next = tobeDelete.next;
            tobeDelete.data = next.data;
            tobeDelete.next = next.next;
        } else {
            //只有一个节点
            if (head == tobeDelete) {
                return head;
            }
            ListNode cur = head;
            while (cur.next != tobeDelete) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
}
