package com.zach.geekbang.alogrithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 4, 7, 6, 3};
        int[] arr = {1, 20, 3, 59, 100, 6, 7, 8, 16, 22, 4, 2, 9, 10};
        //quickSort(arr, 14);
        quickSort2(arr, 14);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    public static void quickSort2(int[] a, int n) {
        sort(a, 0, n - 1);
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = a[left];
        int i = left;
        int j = right;
        while (i != j) {
            //先从右往左找，直到找到比base小的元素(必须先从右往左找，否则结果会错误）
            while (a[j] >= base && i < j) {
                j--;
            }
            //再从左往右找，直到找到比base大的元素
            while (a[i] <= base && i < j) {
                i++;
            }

            //上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        //i==j，回归基准位,将基准数放到中间的位置
        a[left] = a[i];
        a[i] = base;
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r)
            return;
        //获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i=" + i);
        return i;
    }
}
