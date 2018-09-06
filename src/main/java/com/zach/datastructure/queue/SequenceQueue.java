package com.zach.datastructure.queue;

import java.util.Arrays;

/**
 * @Author:Zach
 * @Description:  队列顺序存储结构及实现
 * @Date:Created in 10:08 2018/9/5
 * @Modified By:
 */
public class SequenceQueue<T> {

    private int DEFAULT_SIZE = 4;

    //保存数组的长度
    private int capacity;

    //定义一个数组用于保存顺序队列的元素
    private Object[] elementData;

    //保存顺序队列中元素的当前个数
    private int front = 0;
    private int rear = 0;

    //以默认数组长度创建空顺序队列
    public SequenceQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素创建顺序队列
    public SequenceQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    //以指定长度的数组来创建顺序队列
    public SequenceQueue(T element,int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    //获取顺序队列的大小
    public int length() {
        return rear - front;
    }

    //插入队列
    public void add(T element) {
        if(rear > capacity - 1) {
            throw new IndexOutOfBoundsException("队列已满");
        }

        elementData[rear++] = element;
    }

    //移除队列
    public T remove() {
        if(empty()){
            throw new IndexOutOfBoundsException("空队列");
        }

        //保留队列的front端的元素的值
        T oldValue = (T) elementData[front];
        elementData[front++]=null;
        return oldValue;
    }

    //判断顺序队列是否为空队列
    private boolean empty() {
        return rear == front;
    }

    //返回队顶元素,但是不删除
    public T element() {
        if(empty())
            throw new IndexOutOfBoundsException("空队列异常");
        return (T)elementData[front];
    }

    //清空顺序队列
    public void clear() {

        //将底层数组所有元素赋为null
        Arrays.fill(elementData,null);
        front = 0;
        rear = 0;
    }

    public String toString() {
        if(empty())
            return "[]";
        else{
            StringBuilder sb = new StringBuilder("[");
            for(int i= front; i<rear;i++){
                sb.append(elementData[i].toString()+",");
            }
            int len = sb.length();
            return sb.delete(len-2,len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        SequenceQueue<String> queue = new SequenceQueue<>();

        //依次将4个元素加入队列
        queue.add("aaaa");
        queue.add("bbbb");
        queue.add("cccc");
        queue.add("dddd");
        System.out.println(queue);
        System.out.println("访问队列的front端元素:"+queue.element());
        System.out.println("移除队列的front端元素: "+queue.remove());
        System.out.println("移除队列的front端元素: "+queue.remove());
        System.out.println("移除队列的front端元素: "+queue.remove());
        System.out.println("移除队列的front端元素: "+queue.remove());
        System.out.println("多次次调用remove方法后的队列: "+queue);

        //此时会出现假满现象
        //queue.add("eeee");
    }

}
