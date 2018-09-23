package com.zach.datastructure.book.queue;

import java.util.Arrays;

/**
 * @Author:Zach
 * @Description:  循环队列基于数组的实现
 * @Date:Created in 14:34 2018/9/5
 * @Modified By:
 */
public class LoopQueue<T> {

    private int DEFAULT_SIZE = 10;

    //保存数组的长度
    private int capacity;

    //定义一个数组用于保存循环队列的元素
    private Object[] elementData;

    //保存循环队列中当前元素的个数
    private int front = 0;
    private int rear = 0;

    //以默认数组的长度创建空循环队列
    public LoopQueue(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素创建循环队列
    public LoopQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    //以指定长度的数组来创建循环队列
    public LoopQueue(T element,int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    //循环队列的大小
    public int length() {
        if(empty())
            return 0;
        return rear>front ? rear - front : capacity -(front - rear);
    }

    //插入队列
    public void add(T element) {
        if(rear == front && elementData[front] !=null){
            throw new IndexOutOfBoundsException("队列已满的异常");
        }

        elementData[rear++] = element;

        //如果rear已经到头,那就转头
        rear = rear == capacity ? 0 : rear;
    }

    //判断循环队列是否为空队列
    private boolean empty() {
        return rear == front && elementData[rear] == null;
    }

    //清空循环队列
    public void clear() {

        //将底层数组所有元素赋为null
        Arrays.fill(elementData,null);
        front = 0;
        rear = 0;
    }

    //移除队列
    public T remove() {
        if(empty())
            throw new IndexOutOfBoundsException("空队列异常");

        //保留队列rear端元素的值
        T oldValue = (T)elementData[front];
        //释放队列rear端的元素
        elementData[front++] = null;
        //如果front已经到头,则转头
        front = front == capacity ? 0 : front;
        return oldValue;
    }

    public String toString() {
        if(empty())
            return "[]";
        else {
            //如果front<rear,有效元素就是front到rear之间的元素
            if(front <rear){
                StringBuilder sb = new StringBuilder("{");
                for (int i = 0; i < rear; i++) {
                    sb.append(elementData[i].toString()+",");
                }

                int len = sb.length();
                return sb.delete(len-2,len).append("]").toString();
            }

            //如果front >=rear,有效元素front到capacity之间,0到rear之间的元素
            else{
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    sb.append(elementData[i].toString()+",");
                }
                for (int i = 0; i < rear; i++) {
                    sb.append(elementData[i].toString()+",");
                }

                int len = sb.length();
                return sb.delete(len-2,len).append("]").toString();
            }
        }
    }

    public static void main(String[] args) {
        LoopQueue<String> queue = new LoopQueue<>("aaaa",3);

        //添加两个元素
        queue.add("bbbb");
        queue.add("cccc");

        //此时队列已满
        System.out.println(queue);

        //删除一个元素
        queue.remove();

        System.out.println("删除一个元素后的队列: "+queue);

        queue.add("dddd");
        System.out.println(queue);
        System.out.println("队列满时的长度: "+queue.length());

        //删除一个元素后,队列可以再多加一个元素
        queue.remove();

        queue.add("eeee");
        System.out.println(queue);
    }
}
