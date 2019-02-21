package com.zach.geekbang.alogrithm;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,9};
        mergeSort(a);
    }

    public static void mergeSort(int[] A) {
        int len = A.length;
        int r = len - 1;
        mergeSortInternally(A, 0, r);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r)
            return;
        int q = (p + r) / 2;
        //分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        //将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a,p,q,r);


    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] temp = new int[r-p+1];//申请一个临时数组
        while (i<=q && j<=r){
            if(a[i] <= a[j]) {
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }

        //将剩余的数据拷贝到临时数组temp
        while (start <=end) {
            temp[k++] =a[start++];
        }

        //将tmp数组拷贝回a[p...r]
        for(i = 0;i<=r-p;++i) {
            a[p+i] = temp[i];
        }
    }
}
