package com.zach.frequency;

import java.util.Stack;

/**
 * Created by Zach
 * Date :2020/12/24 10:12
 * Description :设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    //数组栈[当前值,当前最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.add(new int[]{x, x});
        } else {
            stack.add(new int[]{x, Math.min(stack.peek()[1], x)});
        }
    }

    public int pop() {
        return stack.pop()[0];
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {

    }

}
