package com.zach.frequency;

/**
 * @Classname LinkStack
 * @Description:
 * @Date 2020/7/18 15:23
 * @Author: Zach
 * @version: V1.0
 */
public class LinkStack<T> {
    //保存栈顶元素
    private Node top;
    //记录栈中元素的个数
    private int size;

    //以指定元素创建链栈,此时只有一个元素
    public LinkStack(T element) {
        this.top = new Node(element, null);
        size++;
    }

    //创建空栈
    public LinkStack() {
        //top的值为null
        top = null;
    }

    public boolean empty() {
        return size == 0;
    }

    //入栈
    public void push(T data) {
        top = new Node(data, top);
        size++;
    }

    //出栈
    public T pop() {
        if (top == null) {
            return null;
        }
        Node old = top;
        //让top指向栈顶元素的下一个节点
        top = top.next;
        //释放原栈顶元素对next的引用
        old.next = null;
        size--;
        return old.data;

    }

    class Node {
        private T data;
        private Node next;

        //无参数构造器
        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
