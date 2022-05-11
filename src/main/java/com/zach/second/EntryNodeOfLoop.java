package com.zach.second;

import com.zach.common.ListNode;

/**
 * @Description: 环的入口节点
 * @Author Zach
 * @Date 2022/4/26 7:58
 * Version :1.0
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    public static ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while ( slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
