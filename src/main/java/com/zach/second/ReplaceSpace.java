package com.zach.second;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:替换空格 将一个字符串中的空格替换成 "%20"。
 * <p>
 * Input:
 * "A B"
 * Output:
 * "A%20B"
 * @Author Zach
 * @Date 2021/8/29 8:45
 * Version :1.0
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String result = replaceSpace("A B");
        System.out.println(result);
    }

    /**
     *
        由于每次替换从 1 个字符变成 3 个字符，使用字符数组可方便地进行替换。建立字符数组地长度为 s 的长度的 3 倍，
        这样可保证字符数组可以容纳所有替换后的字符。
     * @param str
     * @return
     */
    public static String replaceSpace(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}
