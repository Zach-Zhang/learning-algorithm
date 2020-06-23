package com.zach.frequency;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname ReverseLinkedList
 * @Description: 从尾到头反过来打印出每个结点的值。
 * @Date 2020/6/23 15:09
 * @Author: Zach
 * @version: V1.0
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    /**
     * @return {@link List< Integer>}
     * @Author Zach
     * @Description 使用递归的方法
     * 原理:
     * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，最后再打印第一个节点 1。而链表 2->3 可以看成一
     * 个新的链表，要逆序打印该链表可以继续使用求解函数，也就是在求解函数中调用自己，这就是递归函数。
     * @Date 15:25 2020/6/23
     * @Param [listNode]
     **/
    public static List<Integer> recurseLinkedList(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        if (listNode != null) {
            result.addAll(recurseLinkedList(listNode.next));
            result.add(listNode.getData());
        }
        return result;
    }

    /**
     * @return {@link List< Integer>}
     * @Author Zach
     * @Description 使用头插法
     * 使用头插法可以得到一个逆序的链表。
     * 头结点和第一个节点的区别：
     * 头结点是在头插法中使用的一个额外节点，这个节点不存储值；
     * 第一个节点就是链表的第一个真正存储值的节点
     * @Date 16:07 2020/6/23
     * @Param [listNode]
     **/
    public static List<Integer> insertHead(ListNode listNode) {
        ListNode head = new ListNode(-1, null);
        List<Integer> result = new ArrayList<>();
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }
        head = head.next;
        while (head != null) {
            result.add(head.getData());
            head = head.next;
        }
        return result;
    }

    public static List<Integer> printListFromTailToHeadBystatck(ListNode listNode) {
        Stack stack = new Stack();
        List<Integer> result = new ArrayList<>();
        while (listNode != null) {
            stack.add(listNode.data);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            result.add(Integer.class.cast(stack.pop()));
        }
        return result;
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
