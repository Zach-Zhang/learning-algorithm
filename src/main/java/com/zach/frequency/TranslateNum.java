package com.zach.frequency;

/**
 * @Description:把数字翻译成字符串 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，
 * 例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不
 * 同的翻译方法
 * @Author Zach
 * @Date 2021/5/25 7:38
 * Version :1.0
 */
public class TranslateNum {
    public static void main(String[] args) {
        int count = translateNum(12258);
        System.out.println(count);
    }

    public static int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0)
                continue;
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("26") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
}
