package com.zach.alogrithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BuildArrayWithStack
 * @Description: Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.
 * <p>
 * Build the target array using the following operations:
 * <p>
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array.
 * If the target array is already built, stop reading more elements.
 * You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.
 * <p>
 * Return the operations to build the target array.
 * <p>
 * You are guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation:
 * Read number 1 and automatically push in the array -> [1]
 * Read number 2 and automatically push in the array then Pop it -> [1]
 * Read number 3 and automatically push in the array -> [1,3]
 * Example 2:
 * <p>
 * Input: target = [1,2,3], n = 3
 * Output: ["Push","Push","Push"]
 * Example 3:
 * <p>
 * Input: target = [1,2], n = 4
 * Output: ["Push","Push"]
 * Explanation: You only need to read the first 2 numbers and stop.
 * Example 4:
 * <p>
 * Input: target = [2,3,4], n = 4
 * Output: ["Push","Pop","Push","Push","Push"]
 * @Date 2020/5/14 11:01
 * @Author: Zach
 * @version: V1.0
 */
public class BuildArrayWithStack {
    public static void main(String[] args) {
        int[] target = {2, 3, 4};
        int n = 3;
        buildArrayWithStack(target, 4);
    }

    public static void buildArrayWithStack(int[] target, int n) {
        int length = target.length;
        int index = 0;
        List<String> list = new ArrayList<>(target.length);
        for (int i = 1; i <= n; i++) {
            //根据题意,从1~n遍历,取出数组元素,如果跟i相等,则直接push,否则就先push再pop
            if (target[index] == i) {
                list.add("Push");
                index++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
            if (index == length) {
                break;
            }

        }

        printList(list);

    }

    private static <T> void printList(List<T> list) {
        StringBuilder stringBuilder = new StringBuilder("[");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                stringBuilder.append(list.get(i) + ",");
            } else {
                stringBuilder.append(list.get(i) + "]");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
