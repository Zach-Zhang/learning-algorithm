package com.zach.frequency;

/**
 * Created by Zach
 * Date :2020/11/1 10:21
 * Description : 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变
 * Version :1.0
 */
public class ChangeIndexInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11};
        changeIndex(arr);
    }

    public static void changeIndex(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int[] odd = new int[len];
        int[] even = new int[len];
        int oddIndex = 0;
        int eventIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int result = array[i] % 2;
            if (result != 0) {
                odd[oddIndex++] = array[i];
            } else {
                even[eventIndex++] = array[i];
            }
        }
        int oddLen = odd.length;
        //将偶数追加到奇数的末尾
        if (oddIndex != 0) {
            oddIndex -= 1;
            for (int i = 0; i < eventIndex; i++) {
                if (oddIndex < len)
                    odd[++oddIndex] = even[i];
            }
        } else {
            //全部是偶数
            odd = even;
        }

        //打印
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < odd.length; i++) {
            if (i < odd.length - 1) {
                stringBuilder.append(odd[i]).append(",");
            } else {
                stringBuilder.append(odd[i]).append("]");
            }
        }

        System.out.println(stringBuilder.toString());

    }
}
