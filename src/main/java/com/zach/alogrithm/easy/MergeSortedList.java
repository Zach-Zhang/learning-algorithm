package com.zach.alogrithm.easy;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
       /* ListNode l0 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l0;
        l0.next = l2;
        l2.next=l3;
        l3.next = l4;*/

        System.out.println(mergeTwoLists(l1,l2));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        //确定头结点
        ListNode head = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (l1.val < l2.val) {
            head = l1;
            p1 = p1.next;
        } else {
            head = l2;
            p2 = p2.next;
        }

        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }

        if (p1 == null && p2 == null) {
            return head;
        }

        if (p1 != null && p2 == null) {
            p.next = p1;
        } else if (p1 == null && p2 != null) {
            p.next = p2;
        }
        return head;

    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
