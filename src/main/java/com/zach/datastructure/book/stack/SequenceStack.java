package com.zach.datastructure.book.stack;

import java.util.Arrays;

/**
 * @Author:Zach
 * @Description:  栈的顺序存储结构
 * @Date:Created in 10:17 2018/9/4
 * @Modified By:
 */
public class SequenceStack<T> {

    private int DEFAULT_SIZE = 10;
    //保存数组的长度
    private int capacity;

    //定义一个数组容量不够时,每次增加的数组长度
    private int capacityIncrement = 0;

    //定义一个数组用于保存顺序栈的元素
    private Object[] elementData;

    //保存顺序栈中元素的当前个数
    private int size = 0;

    //以默认数组长度创建空顺序栈
    public SequenceStack() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以初始化元素来创建顺序栈
    public SequenceStack(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    //以指定长度的数组来创建顺序栈
    public SequenceStack(T element,int initSize){
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }


    //以指定长度的数组来创建顺序栈
    public SequenceStack(T element,int initSize,int capacityIncrement) {
        this.capacity = initSize;
        this.capacityIncrement = capacityIncrement;
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //获取顺序栈的大小
    public int length() {
        return size;
    }

    //入栈
    public void push(T element) {
        ensureCapacity(size +1 );
        elementData[size++] = element;
    }


    private void ensureCapacity(int minCapacity) {

        //若数组的原有的长度小于目前所需的长度
        if(minCapacity > capacity){
            if(capacityIncrement>0){
                while (capacity<minCapacity){
                    //不断将capacity长度加capacityIncrement直到capacity大于minCapacity为止
                    capacity += capacityIncrement;
                }
            }else {
                //不断将capacity*2,直到capacity大于minCapacity为止
                while (capacity<minCapacity)
                    capacity <<= 1;
            }

            elementData = Arrays.copyOf(elementData,capacity);
        }
    }

    //出栈
    public T pop() {
        T oldValue = (T) elementData[size-1];

        //释放栈顶元素
        elementData[--size] = null;
        return oldValue;
    }

    //返回栈顶元素,但是不删除栈顶元素
    public T peek() {
        return (T)elementData[size-1];
    }

    //判断顺序栈是否为空栈
    public boolean empty() {
        return size == 0;
    }

    //清空顺序栈
    public void clear() {
        Arrays.fill(elementData,null);
        size = 0;
    }

    public String toString() {
        if(size == 0){
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = size-1; i >-1 ; i--) {
                sb.append(elementData[i].toString()+",");
            }

            int len = sb.length();
            return sb.delete(len-2,len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        SequenceStack<String> stack = new SequenceStack<>();

        //不断地入栈
        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("cccc");
        stack.push("dddd");

        System.out.println(stack);

        //访问栈顶元素
        System.out.println("访问栈顶元素: "+stack.peek());

        //弹出一个元素
        System.out.println("第一次弹出栈顶元素: "+stack.pop());

        //再次弹出一个元素
        System.out.println("第二次弹出栈顶元素: "+stack.pop());

        System.out.println("两次pop之后的栈: "+stack);
    }
}
