package com.zach.frequency;

import com.zach.common.ListNode;

/**
 * Created by Zach
 * Date :2020/11/24 8:29
 * Description : 反转链表
 * 定义一个函数,输入一个链表的头节点,反转该链表并输出反转后链表的头节点
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * Version :1.0
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    /**
     * @return com.zach.common.ListNode
     * @Author Zach
     * @Description 递归反转链表
     * @Date 8:46 2020/11/24
     * @Param [head]
     **/
    public static ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode next = head.getNext();
        head.setNext(null);
        ListNode newHead = recursiveReverseList(next);
        next.setNext(head);
        return newHead;
    }

    /**
     * @return com.zach.common.ListNode
     * @Author Zach
     * @Description 头插法迭代处理
     * @Date 8:56 2020/11/24
     * @Param [head]
     **/
    public static ListNode reverseListIterator(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(newHead.getNext());
            newHead.setNext(head);
            head = next;
        }
        return newHead.getNext();
    }
}
