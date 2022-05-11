package com.zach.second;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * Input:
 * S="abcXYZdef"
 * K=3
 * Output:
 * "XYZdefabc
 * @Author Zach
 * @Date 2022/4/18 8:12
 * Version :1.0
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String target = reverseLeftWords2("abcXYZdef", 3);
        System.out.println(target);
    }

    public static String reverseLeftWords(String source, int k) {
        if (StringUtils.isBlank(source) || k < 0) {
            return source;
        }
        StringBuilder builder = new StringBuilder();
        StringBuilder tailBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i >= k) {
                builder.append(source.charAt(i));
            } else {
                tailBuilder.append(source.charAt(i));
            }
        }
        return builder.append(tailBuilder.toString()).toString();
    }

    /**
     * 取余
     * @param source
     * @param k
     * @return
     */
    public static String reverseLeftWords2(String source, int k) {
        if (StringUtils.isBlank(source) || k < 0) {
            return source;
        }
        StringBuilder builder = new StringBuilder();
        int len = source.length();
        for (int i = k; i < len + k; i++) {
            builder.append(source.charAt(i % len));
        }
        return builder.toString();
    }
}
