package com.zach.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 中文字符串转为long型整数。（输入保证在long的范围内）
 * 输入：三千二百零一万九千七百六十五亿四千三百二十一万九千八百七十六
 *
 * 输出：3201976543219876
 */

public class ParseChineseNumber {
    Map<Character,Character> numberConvert = new HashMap<Character,Character>(){
        {
            put('零','0');
            put('一','1');
            put('二','2');
            put('三','3');
            put('四','4');
            put('五','5');
            put('六','6');
            put('七','7');
            put('八','8');
            put('九','9');
        }

    };
    public static void main(String[] args) {
        String numStr = "三千二百零一万九千七百六十五亿四千三百二十一万九千八百七十六";
        long num = new ParseChineseNumber().parseChineseNumber(numStr);
        System.out.println(num);
    }

    public long parseChineseNumber(String number){
        if(StringUtils.isBlank(number)){
            throw new IllegalArgumentException();
        }
        StringBuffer appender = new StringBuffer();
        for (int i = 0; i < number.toCharArray().length; i++) {
            Character cha = number.charAt(i);
            if(numberConvert.get(cha)!=null){
                appender.append(numberConvert.get(cha));
            }
        }
        long num=0;
        long bitNum = 1;
        for (int i = appender.length()-1; i >=0; i--) {
            num += (appender.charAt(i)-'0')*bitNum;
            bitNum=bitNum*10;
        }
        return num;
    }
}
