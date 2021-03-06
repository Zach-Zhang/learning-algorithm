package com.zach.geekbang.datastructure.heap;

/**
 * @Classname Heap
 * @Description:
 * @Date 2020/6/17 23:05
 * @Author: Zach
 * @version: V1.0
 */
public class Heap {
    //数组,从下标1开始存储数据
    private int[] a;
    //堆可以存储的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            //堆满了
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        //自下往上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            this.swap(a, i, i / 2);
            i = i / 2;
        }
    }

    //删除一个元素
    public void removeMax() {
        if (count == 0)
            return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private static void heapify(int[] a, int n, int i) {
        //自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    //建堆
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //堆排序
    public static void sort(int[] a, int n){
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            if (k > 1) {
                swap(a, 1, k);
                --k;
                heapify(a, k, 1);
            }
        }
    }

}
