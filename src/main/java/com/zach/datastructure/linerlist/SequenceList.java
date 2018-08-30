package com.zach.datastructure.linerlist;

import java.util.Arrays;

/**
 * 采用数组实现顺序线性表
 * @param <T>
 */
public class SequenceList<T> {

    private int DEFAULT_SIZE = 16;

    //保存数组的长度
    private int capacity;

    //定义一个数组用于保存顺序线性表的元素
    private Object[] elementData;

    //顺序表中元素的个数
    private int size = 0;

    //以默认数组长度创建空顺序线性表
    public SequenceList(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始化元素创建顺序线性表
    public SequenceList(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    //以指定长度的数组来创建顺序线性表
    public SequenceList(T element, int initSize) {
        capacity = 1;

        //把capacity设为大于initSize的最小的2的n次方
        while (capacity<initSize) {
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //获取顺序线性表的大小
    public int length() {
       return size;
    }

    //获取线性表中索引为i处的元素
    public T get(int i) {
        if(i<0 || i>size-1)
            throw new IndexOutOfBoundsException("线性表索引越界");

        return (T)elementData[i];
    }

    //查找顺序线性表中指定元素的索引
    public int locate(T element) {
        for (int i = 0; i < size; i++) {
            if(elementData[i].equals(element))
                return i;
        }

        return -1;
    }

    //向顺序线性表中指定位置插入一个元素
    public void insert(int index,T element){

        if(index<0 || index>size)
            throw new IndexOutOfBoundsException("线性表索引越界");

        ensureCapacity(size+1);
       //将指定索引出之后的所有元素向后移动一格
        for (int i = size-1; i >=index ; i--) {
            elementData[i+1] = elementData[i];
        }
        elementData[index] = element;
        size++;
    }

    //在线性顺序表的开始出添加一个元素
    public void add(T element){
        insert(size, element);
    }
    private void ensureCapacity(int minCapacity) {
        //如果数组原有的长度小于目前所需的长度
        if(minCapacity>capacity){
            //不断将capacity*2,直到capacity大于minCapacity
            while (capacity<minCapacity)
                capacity<<=1;
            elementData = Arrays.copyOf(elementData,capacity);
        }
    }

    //删除顺序线性表中指定索引出的元素
    public T delete(int index){
        if(index<0 || index>size-1)
            throw new IndexOutOfBoundsException("线性表索引越界");

        T element = (T) elementData[index];

        //将index后面的元素向前移动一位
        for (int i = index+1; i < size; i++) {
            elementData[i-1] = elementData[i];
        }
        //清空最后一个元素
        elementData[--size] = null;
        return element;
    }

    //删除顺序线性表中最后一个元素
    public T remove() {
        return delete(size-1);
    }

    //判断顺序线性表是否为空表
    public boolean empty() {
        return size == 0;
    }

    //清空线性表
    public void clear() {

        //将底层数组所有元素赋为null
        Arrays.fill(elementData,null);
    }

    public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("SequenceList: size = %d, capacity = %d\n",size,elementData.length));
            sb.append("[");

            for (int i = 0; i <size ; i++) {
                sb.append(elementData[i]);
                if(i !=size-1)
                    sb.append(",");
            }
            sb.append("]");
            return  sb.toString();
    }

    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        list.insert(1,"ddd");
        System.out.println(list);
        list.delete(2);

        System.out.println("ccc在表中的顺序: "+list.locate("ccc"));
        System.out.println(list);
    }

}
