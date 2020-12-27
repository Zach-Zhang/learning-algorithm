package com.zach.frequency;

import java.util.Stack;

/**
 * Created by Zach
 * Date :2020/12/27 11:45
 * Description :输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * Version :1.0
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushSequence = new int[]{1, 2, 3, 4, 5};
        int[] popSequence = new int[]{4, 5, 3, 2, 1};
        System.out.println(isPopOrder(pushSequence,popSequence));
    }

    public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        Stack<Integer> stack = new Stack();
        int len = pushSequence.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < len; pushIndex++) {
            //模拟入栈操作
            stack.push(pushSequence[pushIndex]);
            //比较栈顶元素是否对于出栈的序列值
            while (popIndex < len && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
