package com.zach.second;

import com.zach.common.ListNode;

/**
 * @Description: 删除链表中重复的结点
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，
 * 只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * @Author Zach
 * @Date 2022/4/22 8:50
 * Version :1.0
 */
public class DeleteDuplicateNode {
    public static void main(String[] args) {

    }

    /**
     * 迭代遍历，哨兵节点
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicateNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(head, -1);
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.data == cur.next.next.data) {
                int value = cur.next.data;
                //遍历找出所有与value值相等的节点
                while (cur.next != null && cur.next.data == value) {
                    //删除cur.next
                    cur.next = cur.next.next;
                }
            } else {
                //没有相等节点，指针向右遍历
                cur = cur.next;
            }
        }
        return pre.next;
    }

    /**
     * 递归删除
     *
     * @param head
     * @return
     */
    public static ListNode recurDeleteDuplicateNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.data == next.data) {
            while (next != null && next.data == head.data) {
                next = next.next;
            }
            return recurDeleteDuplicateNode(next);
        } else {
            head.next = recurDeleteDuplicateNode(head.next);
            return head;

        }
    }
}
