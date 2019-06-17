package com.zach.geekbang.datastructure.linkedlist;

/**
 * @Author Zhangsz
 * @Description:
 * @Date 2019/5/16 15:06
 * @ClassName SinglyLinkedList
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    /**
     * 功能描述
     * 无头结点,表头部插入,与输入的顺序相反
     *
     * @Author Zhangsz
     * @Description:
     * @date: 2019/5/16
     * @param: * @param value
     * @return: void
     */
    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }

    public void insertToHead(Node newNode) {
        if (head != null) {
            newNode.next = head;
            head = newNode;
        }
        this.head = newNode;
    }

    /**
     * 功能描述
     * 顺序插入,尾部插入
     *
     * @Author Zhangsz
     * @Description:
     * @date: 2019/5/16
     * @param: * @param value
     * @return: void
     */
    public void insertToTail(int value) {
        Node newNode = new Node(value, null);
        insertToTail(newNode);
    }

    private void insertToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null)
            return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null)
            return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null)
            return;
        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null)
            return;
        if (p == head) {
            head = head.next;
            return;
        }
        Node preNode = head;
        while (preNode != null && preNode.next != p) {
            preNode = preNode.next;
        }
        if (preNode == null)
            return;

        preNode.next = preNode.next.next;

    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        if (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null)
            return;
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public static class Node {
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
