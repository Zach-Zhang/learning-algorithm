package com.zach.geekbang.datastructure.queue;

/**
 * @Auther: Zach
 * @Date: 2019/6/23 20:45
 * @Description: 数组实现循环列表
 */
public class CircularQueue {

    //数组:items,数组大小: n
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.n = capacity;
        items = new String[capacity];
    }

    //入队
    public boolean enqueue(String value) {
        //队列满了
        if ((tail + 1) % n == head)
            return false;
        items[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue(String value) {
        //队列为空
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    //打印
    public void printAll (){
        if(n==0)
            return;
        for (int i = head; i % n != tail; i++) {
            System.out.println(items[i]+ " ");
        }
        System.out.println();
    }
}
