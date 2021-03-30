package com.zach.frequency;

import java.util.PriorityQueue;

/**
 * @Description:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数 值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * <p>
 * 例如，
 * <p>
 * [2,3,4]的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * @Author Zach
 * @Date 2021/3/30 21:11
 * Version :1.0
 */
public class MedianFinder {
    /**
     * 思路:
     * 给定一长度为 NN 的无序数组，其中位数的计算方法：首先对数组执行排序（使用 O(N \log N)O(NlogN) 时间），
     * 然后返回中间元素即可（使用 O(1)O(1) 时间）。
     */
    //大顶堆,存储较小的那一半,N为奇数时,元素个数(N-1)/2
    private static PriorityQueue<Integer> largeHeap = new PriorityQueue<>((r1, r2) -> r2 - r1);

    //小顶堆,存储较大的那一半,N为奇数时,元素个数(N+1)/2
    private static PriorityQueue<Integer> smallHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        for (int i : array) {
            addNum(i);
        }
        double median = findMedian();
        System.out.println(median);
    }

    public static void addNum(int num) {
        //N为奇数,向大顶堆添加一个元素,实现方式,先加入小顶堆,再从堆顶取出堆顶堆顶元素,放入大顶堆中(大顶堆元素都比小顶堆元素小)
        if (largeHeap.size() != smallHeap.size()) {
            smallHeap.add(num);
            largeHeap.add(smallHeap.poll());
        } else {
            //N为偶数,向小顶堆添加元素,又因为小顶堆的元素都比大顶堆的元素大,所以,实现方式是先加入大顶堆,再从大顶堆汇中取出堆顶元素放入小顶堆
            largeHeap.add(num);
            smallHeap.add(largeHeap.poll());
        }
    }

    public static double findMedian() {
        return smallHeap.size() != largeHeap.size() ? smallHeap.peek() : (largeHeap.peek() + smallHeap.peek()) / 2.0;
    }
}
