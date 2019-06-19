package com.zach.geekbang.datastructure.queue;

/**
 * @Auther: Zach
 * @Date: 2019/6/19 21:45
 * @Description:
 */
public class DynamicArrayQueue {
    private String[] items;
    //数组大小
    private int n=0;
    //head表示队头下标,tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    //申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队操作
    public boolean enqueue(String item) {
        //tail == n表示整个队列末尾没有空间了
        if(tail == n) {
            //表示tail==n&&head==0表示整个队列都占满了
            if(head == 0)
                return false;

            //数据搬移
            for (int i = head; i <tail ; i++) {
                items[i-head] = items[i];
            }

            //搬完之后重新更新head 和tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    //出队操作
    public String dequeue() {
        //若head==tail表示队列为空
        if(head == tail)
            return null;
        String ret = items[head++];
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.println(items[i]+" ");

        }
        System.out.println();
    }
}
