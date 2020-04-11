package com.zach.alogrithm.easy;

import java.util.PriorityQueue;

/**
 * @Classname largestSumAfterKNegations
 * @Description: Given an array A of integers, we must modify the array in the following way:
 * we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
 * (We may choose the same index i multiple times.)
 * <p>
 * Return the largest possible sum of the array after modifying it in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 * <p>
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 * <p>
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 *
 * @Date 2020/4/9 21:38
 * @Created by Zach
 */
public class largestSumAfterKNegations {
    public static void main(String[] args) {
        int[] A = {3,-1,0,2};
        int k = 3;
        int sum = largestSumAfterKNegations(A, k);
        System.out.println(sum);
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        //优先级队列,按照自然顺序排序(堆排序),头部是最小元素,
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : A) {
            pq.add(x);
        }
        while (K-- > 0) {
            int num = -pq.poll();
            pq.add(num);
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {

            sum += pq.poll();//取出队列头部最小,并从新进行堆排序,将最小的元素放在head位置,这样累加的和是最小的元素
        }
        return sum;
    }
}
