package com.zach.common;

/**
 * Created by Zach
 * Date :2020/11/24 8:31
 * Description :
 * Version :1.0
 */
public class ListNode {
    private ListNode next;
    private int data;

    public ListNode(int data) {
        this.data = data;
    }

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
}
