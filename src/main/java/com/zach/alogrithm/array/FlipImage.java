package com.zach.alogrithm.array;

import com.zach.datastructure.video.dynamicarray.Array;

import java.util.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 *
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class FlipImage {
    public static void main(String[] args) {
        int[][] B = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        //int[][] B = {{1,1,0},{1,0,1},{0,0,0}};
        //flipAndInvertImage(B);

        for (int[] ints : B) {

            System.out.println(Arrays.toString(ints));

        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {


            int[] B = A[i];

            int index = 0;
            int start = 0;
            int end = B.length-1;
            //flip
           while (start < end) {
               int temp =  B[start];
               B[start] = B[end];
               B[end] = temp;

               start++;
               end--;
           }

            //invert
            for (int j = 0; j <B.length; j++) {

               B[j] = B[j]==1 ?0:1;
            }



            A[i] = B;
        }
        return A;
    }
}
