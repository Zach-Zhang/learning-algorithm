package com.zach.geekbang.alogrithm;

/**
 * @Author Zhangsz
 * @Description 插入排序
 * @Date 2019/2/19 16:41
 * @ClassName InsertionSort
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,9};
        insertionSort(a);
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i-1;
            for (;j>=0;--j) {
                if(a[j]>value){
                    a[j+1] = a[j]; //移动数据
                }else
                    break;
            }

            //插入数据
            a[j+1] = value;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
