package com.zach.alogrithm.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: 给一个整型数组，里面有若干个0，其余为非0元素，将0移到后面，其余元素的相对顺序不变，
 * 如[1,0,2,3,0,4]变成[1,2,3,4,0,0],要求in space；
 * @Author Zach
 * @Date 2021/9/6 15:17
 * Version :1.0
 */
public class Test {
    public static void main(String[] args) {
       /* int[] array = new int[]{1, 0, 2, 3, 0, 4};
        List<Integer> sort = sort(array);
        System.out.println(sort);*/
       /* ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        int resut = (-1 << 29) | 0;
        int r2 = (-536870912 & ((1 << 29) - 1));
        System.out.println(resut);
        System.out.println(r2);*/
    }

    public static List<Integer> sort(int[] array) {
        int len = array.length - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            if (array[i] > 0) {
                list.add(array[i]);
            }
        }
        int length = list.size() - 1;
        for (int i = 0; i <= len; i++) {
            if (array[i] == 0) {
                list.add(length + 1, array[i]);
            }
        }
        return list;
    }

}
