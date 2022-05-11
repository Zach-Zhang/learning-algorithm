package com.zach.second;

/**
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 * @Author Zach
 * @Date 2022/4/23 9:09
 * Version :1.0
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,5,6,7};
        int[] result = reOrderArray(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int oddCount = 0;
        for (int i : array) {
            if (!isEvent(i)) {
                oddCount++;
            }
        }
        int len = array.length;
        int[] reOrderArray = new int[len];
        int OddIndex = 0;
        for (int i : array)  {
            if (isEvent(i)) {
                reOrderArray[oddCount++] = i;
            } else {
                reOrderArray[OddIndex++] = i;
            }
        }
        return reOrderArray;
    }

    private static boolean isEvent(int i) {
        return i % 2 == 0;
    }
}
