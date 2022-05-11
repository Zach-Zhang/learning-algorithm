package com.zach.leetcode;

import java.util.PriorityQueue;

/**
 * @Description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @Author Zach
 * @Date 2022/3/10 21:57
 * Version :1.0
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        int result = findKthLargest3(a, 7);
        System.out.println(result);
    }

    public static int findKthLargest1(int[] a, int k) {
        k = a.length - k;
        int l = 0;
        int h = a.length - 1;
        while (l < h) {
            int j = partition1(a, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return a[k];
    }

    /**
     * 优先队列思路： 第K大的元素，就是递增排序之后，数组的后半部分最小的元素，
     * 建一个大小为K的小顶堆，当堆已经满的时候，删除掉堆顶元素，当数组遍历完成后，堆顶元素就是第K大元素
     * @param a
     * @param k
     * @return
     */
    public static int findKthLargest3(int[] a, int k) {
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : a) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    private static int partition1(int[] a, int l, int h) {

        int i = l;
        int j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
        /*int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;*/

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int findKthLargest2(int[] a, int k) {
        int len = a.length;
        k = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition2(a, left, right);
            if (index == k) {
                break;
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return a[k];
    }

    private static int partition2(int[] a, int left, int right) {

        int pivot = a[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] < pivot) {
                // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                j++;
                swap(a, j, i);
            }
        }
        // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
        swap(a, j, left);
        // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >= pivot
        return j;
    }
}
