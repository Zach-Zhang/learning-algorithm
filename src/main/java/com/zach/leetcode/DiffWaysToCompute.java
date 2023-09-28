package com.zach.leetcode;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 *
 * 示例 1：
 *
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 *
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DiffWaysToCompute {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> result = diffWaysToCompute(expression);
        System.out.println("result:"+expression.substring(2));
        System.out.println(result);
    }

    public static List<Integer> diffWaysToCompute(String expression){
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i <expression.length(); i++) {
            char c = expression.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                //枚举操作符所有左边的结果集
               List<Integer> left = diffWaysToCompute(expression.substring(0,i));
               //枚举操作符所有右边的结果集
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                //合并左右两边的结果集
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c){
                            case '+':
                                ways.add(l+r);
                                break;
                            case '-':
                                ways.add(l-r);
                                break;
                            case '*':
                                ways.add(l*r);
                                break;
                            default:
                                break;
                        }
                    }
                }

            }
        }
        if(ways.isEmpty()&& NumberUtils.isDigits(expression)){
            ways.add(Integer.valueOf(expression));
        }
        System.out.println("ways:"+ways);
        return ways;
    }
}
