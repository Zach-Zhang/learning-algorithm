package com.zach.frequency;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Description:字符流中第一个不重复的字符 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符
 * 流中只读出前两个字符 "go" 时，第一个
 * 只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第
 * 一个只出现一次的字符是 "l"。
 * @Author Zach
 * @Date 2021/4/8 18:52
 * Version :1.0
 */
public class FindFirstOneStr {
    static Queue<Character> queue = new LinkedList<>();
    static int[] countArray = new int[256];

    public static void main(String[] args) {

    }

    public static void insert(char cha) {
        countArray[cha]++;
        queue.add(cha);
        while (!queue.isEmpty() && countArray[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public static char findFirstAppearing() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    public static char findFirstAppearingByMap(String target) {
        if (StringUtils.isEmpty(target)) {
            return ' ';
        }
        Map<Character, Integer> position = new HashMap<>();
        int length = target.length();
        for (int i = 0; i < length; i++) {
            char ch = target.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -9);
            } else {
                position.put(ch, i);
            }
        }
        int first = length;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            Integer value = entry.getValue();
            if (value != -1 && value < first) {
                first = value;
            }
        }
        return first == length ? ' ' : target.charAt(first);
    }
}
