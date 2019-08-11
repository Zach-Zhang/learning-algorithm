package com.zach.geekbang.alogrithm;

import java.util.Arrays;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {1, 20, 3, 59, 100, 6, 7, 8, 16, 22, 4, 2, 9, 10};
        bucketSort(arr, 7);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 桶排序
     *
     * @param arr
     * @param bucketSize 桶容量
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2)
            return;
        //计算桶的数量
        int min = arr[0];
        int max = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        int bucksetCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucksetCount][bucketSize];
        //记录每个桶中的数据个数,下标为桶的位置,值为桶内的数据个数
        int[] indexArr = new int[bucksetCount];

        //将数组中的值分配到各个桶里
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - min) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        //对每个桶进行排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0)
                continue;
            //快速排序
            quickSortC(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    private static void quickSortC(int[] arr, int p, int r) {
        if (p >= r)
            return;
        int q = partition(arr, p, r);
        quickSortC(arr, p, q - 1);
        quickSortC(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int j = p;
        for (int i = p; i < r; i++) {
            if(arr[i]==4)
            if (arr[i] <= pivot) {
                swap(arr, j, i);
                j++;
            }
        }
        swap(arr, j, r);
        return j;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 扩容
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = new int[buckets[bucketIndex].length * 2];
        for (int i = 0; i < buckets[bucketIndex].length; i++) {
            tempArr[i] = buckets[bucketIndex][i];
        }
        buckets[bucketIndex] = tempArr;
    }
}
