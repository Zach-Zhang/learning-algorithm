package com.zach.datastructure.queue;

import com.zach.datastructure.stack.LinkStack;

/**
 * @Author:Zach
 * @Description:  链式队列的实现
 * @Date:Created in 10:59 2018/9/6
 * @Modified By:
 */
public class LinkQueue<T> {

    //定义一个内部类Node
    private class Node{

        private Node next;  //下一节点个引用
        private T data;  //存储的数据元素

        public Node() {
        }

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }
    }

    private Node front; //队列的头节点
    private Node rear;  //队列的尾节点
    private int size;   //队列中已包含的节点数

    //创建空队列
    public LinkQueue() {
        front = null;
        rear = null;
    }

    //以指定元素创建队列
    public LinkQueue(T element) {
        front = new Node(null,element);
        //只有一个节点,rear,front都指向该节点
        rear = front;
        size++;
    }

    //返回队列的长度
    public int length() {
        return size;
    }

    //将新元素加入队列
    public void add(T element){
        if(front == null){
            front = new Node(null,element);
            rear = front;
        }else{

            Node newNode = new Node(null,element);

            rear.next = newNode;

            //以新节点作为新的尾节点
            rear = newNode;
        }
        size++;
    }

    //删除队列front端的元素
    public T remove() {
        Node oldNode = front;
        front = front.next;
        oldNode.next = null;
        size--;
        return oldNode.data;
    }

    //访问链式队列中最后一个元素
    public T element(){
        return rear.data;
    }

    //判断队列是否为空
    public boolean empty(){
        return size == 0;
    }

    //清空链队列
    public void clear() {
        //将底层数组所有元素赋为null
        front = null;
        rear = null;
        size = 0;
    }

    public String toString() {
        if(empty()){
            return "[]";
        }

        else {
            StringBuilder sb = new StringBuilder("[");
            for(Node current = front; current !=null;current=current.next){
                sb.append(current.data.toString()+",");
            }

            int len = sb.length();
            return sb.delete(len-2,len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        LinkQueue<String> queue = new LinkQueue<>("aaaa");

        //添加两个元素
        queue.add("bbbb");
        queue.add("cccc");
        System.out.println(queue);

        //删除一个元素后
        queue.remove();
        System.out.println("删除一个元素后的队列: "+queue);

        //再次添加一个元素
        queue.add("dddd");
        System.out.println("再次添加元素后的队列: "+queue);
        //删除一个元素后,队列可以再多加一个元素
        queue.remove();
        //再次加入一个元素
        queue.add("eeee");
        System.out.println(queue);
    }
}
