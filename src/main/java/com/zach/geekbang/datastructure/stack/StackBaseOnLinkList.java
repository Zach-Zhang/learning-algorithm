package com.zach.geekbang.datastructure.stack;

/**
 * 栈基于链表实现
 */
public class StackBaseOnLinkList {
    private Node top;

    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null)
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null)
            return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
