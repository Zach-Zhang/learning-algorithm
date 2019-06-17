package com.zach.geekbang.datastructure.linkedlist;

import java.util.Scanner;

/**
 * @Auther: Zach
 * @Date: 2019/6/15 21:30
 * @Description: 基于单链表LRU淘汰算法:最近最少的使用策略
 */
public class LRUBaseLinkedList<T> {

    //默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;

    //头节点
    private SNode headNode;

    //链表长度
    private Integer length;

    //链表容量
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNodeByValue(data);
        //链表中存在删除原数据,并将新数据插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);

        }
    }

    private void deleteElemAtEnd() {
        SNode temp = headNode;
        if (temp.getNext() == null)
            return;

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        SNode target = temp.getNext();
        temp.setNext(null);
        target = null;
        length--;

    }

    private void intsertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    private void deleteElemOptim(SNode preNode) {
        if (preNode != null) {
            SNode temp = preNode.getNext();
            preNode.setNext(temp.getNext());
            temp = null;
            length--;

        }
    }

    private SNode findPreNodeByValue(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            } else {
                node = node.getNext();
            }
        }
        return null;
    }

    private void printAll(){
        System.out.println("=========");
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.println(node.getElement()+",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (count<10) {
            int temp = sc.nextInt();
            list.add(temp);
            list.printAll();
            count++;
        }
    }
}
