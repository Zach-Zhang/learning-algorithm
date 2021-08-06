package com.zach.frequency;

import java.util.Arrays;

/**
 * @Description:把数组排成最小的数
 * @Author Zach
 * @Date 2021/6/29 8:24
 * Version :1.0
 */
public class MinNumbers {
    public static void main(String[] args) {
        int[] array = {3,32,321};
        System.out.println(minNumbers(array));
    }

    public static String minNumbers(int[] array) {
        String[] strs = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strs[i] = String.valueOf(array[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(strs).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private static void quickSort(String[] strs, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        String temp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[start]).compareTo((strs[start] + strs[j])) >= 0 && i < j){
                j--;
            }
            while ((strs[i]+strs[start]).compareTo((strs[start]+strs[i]))<=0&&i<j){
                i++;
            }
            temp =strs[i];
            strs[i]=strs[j];
            strs[j]=temp;
        }
        strs[i]=strs[start];
        strs[start]=temp;
        quickSort(strs,start,i-1);
        quickSort(strs,i+1,end);

    }

}
