package com.zach.geekbang.alogrithm;

/**
 * @Author Zhangsz
 * @Description 冒泡排序
 *
 * 冒泡排序只会操作相邻的两个数据
 * @Date 2019/2/19 15:14
 * @ClassName BubbleSorts
 */
public class BubbleSorts {

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,9};

        bubbleSort(a);
    }

    public static void bubbleSort(int[] a) {
        int len = a.length;
        if(len <=1)
            return;

        for (int i = 0; i < a.length; i++) {

            boolean flag = false;  //提前退出排序的标志
            for (int j = 0; j < len-i-1; ++j) {
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;  //表示数据交换了
                }
            }

            if(!flag)
                break; //没有数据交换提前退出
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
