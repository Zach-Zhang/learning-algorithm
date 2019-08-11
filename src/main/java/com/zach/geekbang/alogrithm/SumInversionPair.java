package com.zach.geekbang.alogrithm;

/**
 * @Auther: Zach
 * @Date: 2019/4/14 15:36
 * @Description: 运用归并排序思想查找逆序对
 */
public class SumInversionPair {

    private int num = 0; //设置全局变量或成员变量

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r)
            return;
        int q = (p+r)/2;
        mergeSortCounting(a,p,q);
        mergeSortCounting(a,q+1,r);
        merge(a,p,q,r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p,j = q+1,k=0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if(a[i]<=a[j]) {
                tmp[k++] = a[i++];
            }else {
                num += (q-i+1);
                tmp[k++] = a[j++];
            }
        }

        while (i<=q) {
            tmp[k++] = a[i++];
        }

        while (j<=r) {
            tmp[k++] = a[j++];
        }

        for ( i = 0; i <=r-p; i++) {
            a[p+i] = tmp[i];
        }
    }

}