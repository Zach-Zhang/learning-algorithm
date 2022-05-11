package com.zach.second;

import java.util.Stack;

/**
 * @Description: 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数
 * 字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压
 * 栈序列的弹出序列。
 *
 * @Author Zach
 * @Date 2022/5/5 7:51
 * Version :1.0
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushSequence = new int[]{1, 2, 3, 4};
        int[] popSequence = new int[]{4, 3, 1, 2};
        boolean popOrder = isPopOrder(pushSequence, popSequence);
        System.out.println(popOrder);
    }

    public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        if (pushSequence == null || popSequence == null) {
            return false;
        }
        if (pushSequence.length == 0 || pushSequence.length != popSequence.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushLen = pushSequence.length;
        for (int i = 0, popIndex = 0; i < pushLen; i++) {
            stack.add(pushSequence[i]);
            while (popIndex < pushLen && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }

        }
        return stack.isEmpty();
    }
}
