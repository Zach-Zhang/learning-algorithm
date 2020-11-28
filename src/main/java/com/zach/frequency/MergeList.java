package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/11/28 14:53
 * Description : 合并两个排序的链表;
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * 0 <= 链表长度 <= 1000
 * Version :1.0
 */
public class MergeList {
    public static void main(String[] args) {

    }

    /**
     * @return com.zach.frequency.MergeList.ListNode
     * @Description: 递归处理
     * @Date 15:55 2020/11/28
     * @Param [h1, h2]
     **/
    public ListNode recursiveMergeList(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.data <= h2.data) {
            h1.next = recursiveMergeList(h1.next, h2);
            return h1;
        } else {
            h2.next = recursiveMergeList(h1, h2.next);
            return h2;
        }

    }

    /**
     * @return com.zach.frequency.MergeList.ListNode
     * @Description 利用哨兵模式处理
     * @Date 16:04 2020/11/28
     * @Param [h1, h2]
     **/
    public ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if (h1 != null) {
            cur.next = h1;
        }
        if (h2 != null) {
            cur.next = h2;
        }
        return head.next;
    }

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public ListNode(int data) {
            this.data = data;
        }
    }
}
