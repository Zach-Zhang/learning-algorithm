package com.zach.frequency;

import java.util.HashSet;

/**
 * Created by Zach
 * Date :2020/11/14 11:03
 * Description : 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 * Version :1.0
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    //方法一:使用HashSet(不符合题目要求)
    public ListNode entryNodeOfLoop(ListNode head) {
        HashSet<ListNode> nodeHashSet = new HashSet<>();
        while (head != null) {
            // 如果包含了,则这个就是入口节点
            if (!nodeHashSet.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    //方法二:使用双指针,假定fast比slow多走了一环
    public ListNode entryNodeOfLoop2(ListNode head) {
        ListNode slow = head, fast = head;
        //fast每次都两步,slow每次走一步,直到第一次相遇
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        //fast重新回到头结点,slow保持不变,两个指针都每次都一步,直到相遇即为环的入口
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //方法三:使用双指针,假定fast比slow多走了n环
    public ListNode entryNodeOfLoop3(ListNode head) {
        ListNode slow = head, fast = head;
        //fast每次都两步,slow每次走一步,直到第一次相遇
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //快指针与慢指针相遇
            if (slow == fast) {
                fast = head;
                //再次相遇
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(ListNode next, int data) {
            this.next = next;
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
