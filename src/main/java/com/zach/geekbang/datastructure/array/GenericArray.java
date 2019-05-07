package com.zach.geekbang.datastructure.array;

/**
 * @Auther: Zach
 * @Date: 2019/5/7 21:21
 * @Description: 通用数组的部分实现
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        this.data=(T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获取当前元素的个数
    public int count() {
        return size;
    }

    //修改index位置的元素
    public void set(int index,T e) {
        check(index);
        data[index] = e;
    }

    //获取对应索引上的元素
    public T get(int index) {
        check(index);
        return data[index];
    }

    //包含某个元素
    public boolean contain(T e) {
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //在index位置上插入
    public boolean add(int index,T e) {
        if(index <0 || index>size)  {
            throw new IllegalArgumentException("超出索引的要求");
        }

        if(size == data.length) {
            resize(2*data.length);
        }

        for (int i = size; i >index; --i) {
            data[i] = data[i-1] ;
        }
        data[index] = e;
        size++;
        return true;
    }

    //删除元素
    public void delete(int index) {
        check(index);
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] =null;
    }

    private void resize(int count) {
        T[] newData = (T[]) new Object[]{count};

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    private void check(int index) {
        if(index <0 || index>=size)  {
            throw new IllegalArgumentException("超出索引的要求");
        }
    }
}
