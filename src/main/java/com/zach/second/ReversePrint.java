package com.zach.second;

import com.zach.common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 从尾到头打印链表
 * 从尾到头反过来打印出每个结点的值 以数组的形式返回
 * @Author Zach
 * @Date 2022/4/13 7:49
 * Version :1.0
 */
public class ReversePrint {
    private static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(new ListNode(3), 2);
        head.setNext(next);
        /*int[] arr = reversePrint2(head);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        ArrayList<Integer> result = printListFromTailToHead(head);
        System.out.println(result);
    }

    /**
     * 栈，先进后出
     *
     * @param head
     * @return
     */
    public static Object[] reversePrint(ListNode head) {
        LinkedList<Integer> queue = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            queue.offerFirst(p.getData());
            p = p.getNext();
        }
        return queue.toArray();
    }

    /**
     * 递归回溯
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        recur(head);
        int[] arr = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }
        return arr;
    }

    /**
     * 递归
     *
     * @param head
     */
    public static void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.getNext());
        temp.add(head.getData());
    }

    /**
     * 头插法构建逆序节点
     *
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode temp = listNode.getNext();
            listNode.setNext(head.getNext());
            head.setNext(listNode);
            listNode = temp;
        }
        ArrayList<Integer> list = new ArrayList<>();
        head = head.getNext();
        while (head != null) {
            list.add(head.getData());
            head = head.getNext();
        }
        return list;
    }
}
