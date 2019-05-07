package com.zach.geekbang.datastructure.array;

/**
 * @Auther: Zach
 * @Date: 2019/5/1 16:39
 * @Description: 数组的增删改查的实现
 */
public class Array {

    public int data[];

    //数组的长度
    public int n;

    //素组中实际的个数
    public int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //查找
    public int find(int index) {
        if (index < 0 || index >= count)
            return -1;
        return data[index];
    }

    //插入
    public boolean insert(int index, int value) {
        //元素已满
        if (count == n) {
            throw new RuntimeException("数组满了,无法插入元素");
        }

        //插入的位置不合法
        if (index < 0 || index > count) {
            throw new RuntimeException("插入位置不合法");
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        ++count;
        return true;
    }

    //删除元素
    public boolean delete(int index) {
        if (count == 0) {
            return false;
        }
        //插入的位置不合法
        if (index < 0 || index >= count) {
            throw new RuntimeException("插入位置不合法");
        }

        for (int i = index+1; i <count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        System.out.println("=============================");
        array.delete(0);
        array.printAll();
    }
}
