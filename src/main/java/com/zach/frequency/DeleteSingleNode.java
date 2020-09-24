package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/9/24 8:22
 * Description :在 O(1) 时间内删除单向链表节点,
 * Version :1.0
 */
public class DeleteSingleNode {
    public static void main(String[] args) {

    }

    public static ListNode deleteNode(ListNode head, ListNode deleteNode) {
        if (head == null || deleteNode == null) {
            return null;
        }
        //要删除的节点不是尾结点
        if (deleteNode.next != null) {
            ListNode next = deleteNode.next;
            deleteNode.data = next.data;
            deleteNode.next = next.next;
        } else {
            //只有一个节点
            if (head == deleteNode) {
                head = null;
            } else {
                ListNode cur = head;
                while (cur.next != deleteNode) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
