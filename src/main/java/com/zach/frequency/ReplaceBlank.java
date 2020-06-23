package com.zach.frequency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ReplaceBlank
 * @Description: 将一个字符串中的空格替换成 "%20"。
 * Input:
 * "A B"
 * <p>
 * Output:
 * "A%20B"
 * @Date 2020/6/17 16:32
 * @Author: Zach
 * @version: V1.0
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        System.out.println(replaceBlank("A  B C"));
        Lock lock = new ReentrantLock();
    }

    public  static String replaceBlank(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char ch = stringBuilder.charAt(i);
            if (ch == ' ') {
                stringBuilder.setCharAt(i, '%');
                stringBuilder.insert(i + 1, '2');
                stringBuilder.insert(i + 2, '0');
            }
        }
        return stringBuilder.toString();
    }
}
