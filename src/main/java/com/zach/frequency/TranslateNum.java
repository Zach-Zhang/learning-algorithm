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
        int i = dfsTranslateNum(12258);
        System.out.println(count);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * @param num
     * @return
     */
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

    /**
     * dfs递归
     */
    public static int dfsTranslateNum(int num) {
        String str = String.valueOf(num);
        return dfs(str, 0);
    }


    public static int dfs(String str, int index) {
        //如果当前的下标大于等于字符串的长度-1,则说明当前位置是由上一次跳到此处的,则直接返回1
        if (index >= str.length() - 1) {
            return 1;
        }
        //先求出每一次都翻译一个字符的方法数
        int res = dfs(str, index + 1);
        //截取两位,查看数字是否在10-26之间
        String temp = str.substring(index, index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("26") <= 0) {
            //从两字符后面开始翻译
            res += dfs(str, index + 2);
        }
        return res;
    }
}
