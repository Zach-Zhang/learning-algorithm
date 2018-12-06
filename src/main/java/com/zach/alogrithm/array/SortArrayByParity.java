package com.zach.alogrithm.array;

import com.zach.datastructure.video.dynamicarray.Array;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4,66,55,77,88};

        int[] s = solution(arr);
        System.out.println(Arrays.toString(s));
    }

    public static int[] solution(int[] A) {

        int[] even = new int[A.length];
        int[] odd = new int[A.length];
        int index = 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even[index++] = A[i];
            } else {
                odd[j++] = A[i];
            }
        }

        for (int i = 0; i < odd.length; i++) {
            if (odd[i] != 0)
                even[index++] = odd[i];
        }

        return even;

    }
}
