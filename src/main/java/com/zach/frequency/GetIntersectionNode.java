package com.zach.frequency;

/**
 * @Description:两个链表的第一个公共结点
 * @Author Zach
 * @Date 2021/8/8 8:27
 * Version :1.0
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode indexA = headA;
        ListNode indexB = headB;
        /**
         * 双指针法: 当指针A到达headA的尾结点时,将指针指向headB,同理当指针B指到headB的尾结点时,将指针B指向headA,当指针A与指针B相等时,即此时是第一个公共结点
         * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
         */
        while (indexA != headB) {
            indexA = indexA == null ? headB : indexA.next;
            indexB = indexA == null ? headA : indexB.next;
        }
        return indexA;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
