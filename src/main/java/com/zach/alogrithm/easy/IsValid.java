package com.zach.alogrithm.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: '()'
 * Output: true
 * Example 2:
 * <p>
 * Input: '()[]{}'
 * Output: true
 * Example 3:
 * <p>
 * Input: '(]'
 * Output: false
 * Example 4:
 * <p>
 * Input: '([)]'
 * Output: false
 * Example 5:
 * <p>
 * Input: '{[]}'
 * Output: true
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "({[}(]})";
        System.out.println(isValidOne(s));

    }

    //方法一
    public static boolean isValidOne(String s) {
        if (s.equals("")) {
            return true;
        }
        //长度检查
        if (s==null || s.length() % 2 ==1) {
            return false;
        }
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{') return false;
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(') return false;
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[') return false;
                    break;
            }
        }
        return head == 0;
    }

    //方法二
    public static boolean isValidTwo(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
