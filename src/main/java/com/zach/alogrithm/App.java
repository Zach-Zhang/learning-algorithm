package com.zach.alogrithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println( "Hello World!" );
        HashMap<String, String> hashMap = new HashMap<>(10);
        List<String> list = new ArrayList<>(10);
        int n = 10 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println(n + 1);
    }

    public static void printArray(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                sb.append(nums[i]).append(",");
            } else {
                sb.append(nums[i]).append("]");
            }
        }
        System.out.println(sb.toString());
    }
}
