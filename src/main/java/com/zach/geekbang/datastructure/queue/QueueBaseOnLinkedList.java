package com.zach.geekbang.datastructure.queue;

/**
 * @Auther: Zach
 * @Date: 2019/6/22 10:23
 * @Description:
 */
public class QueueBaseOnLinkedList {

    //队列的首和尾
    private Node head = null;
    private Node tail = null;

    //入队操作
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(null, value);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(null, value);
            //tail向后移动
            tail = tail.next;
        }
    }

    //出队操作
    public String dequeue() {
        if (head == null) {
            return null;
        }
        String value = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private Node next;
        private String data;

        public Node(Node next, String data) {
            this.next = next;
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}
