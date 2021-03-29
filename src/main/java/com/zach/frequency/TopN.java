package com.zach.frequency;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description:输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 0 <= k <= arr.length <= 10000
 * @Author Zach
 * @Date 2021/3/23 22:06
 * Version :1.0
 */
public class TopN {
    public static void main(String[] args) {

    }

    public void heapSort(int[] array, int k) {
        buildHeap(array, k);
        int n = k;
        while (k > 1) {
            if (k > 1) {
                swap(array, 1, k);
                --k;
                heapify(array, k, 1);
            }
        }
    }

    public static void buildHeap(int[] array, int k) {
        for (int i = k / 2; i >= 1; i--) {
            heapify(array, k, i);
        }
    }

    /**
     * 堆的左子节点下标为i*2,右子节点下标是i*2+1,父节点是i/2
     *
     * @param array
     * @param n
     * @param i
     */
    public static void heapify(int[] array, int n, int i) {
        while (true) {
            int maxPos = i;

            if (i * 2 <= n && array[i] < array[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && array[maxPos] < array[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }

            if (i == maxPos) {
                break;
            }
            //交换元素
            swap(array, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static List<Integer> getLeastNumber(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return new ArrayList<>(0);
        }
        //建立一个大小为K的大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((r1, r2) -> r2 - r1);
        for (int num : nums) {
            maxHeap.add(num);
            //k+1之后的元素,每次都poll出堆顶最大的数,堆中就剩余了前K个最小的元素(堆顶仍然是最大的元素)
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
