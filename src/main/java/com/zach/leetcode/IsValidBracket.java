package com.zach.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 */
public class IsValidBracket {
   static Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}');
        put('(',')');
        put('[',']');

    }};
    public static void main(String[] args) {
        String str = "()[{}";
        boolean valid = isValid(str);
        System.out.println(valid);
    }

    public static boolean  isValid(String validStr){
        if(StringUtils.isBlank(validStr)){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < validStr.toCharArray().length; i++) {
            char ch = validStr.charAt(i);
            if(map.containsKey(ch)){
                stack.addLast(ch);
            }else {
                if(map.get(stack.removeLast())!=ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
