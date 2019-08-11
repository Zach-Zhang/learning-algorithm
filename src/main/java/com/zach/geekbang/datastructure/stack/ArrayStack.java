package com.zach.geekbang.datastructure.stack;

/**
 * 栈的数组实现
 */
public class ArrayStack {
    private String[] items;
    private int count;//数组中元素的个数
    private int n;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    //入栈操作
    public boolean push(String item) {
        if (n == count)
            return false;
        items[count++] = item;
        return true;
    }

    //出栈操作
    public String pop() {
        if(count==0){
            return null;
        }

        String tmp = items[count-1];
        count--;
        return tmp;
    }
}
