package com.zach.second;

import org.checkerframework.checker.units.qual.C;

import java.util.Stack;

/**
 * @Description:
 * @Author Zach
 * @Date 2022/4/19 9:24
 * Version :1.0
 */
public class CustomQueue {
    public Stack<Integer> in = new Stack<>();
    public Stack<Integer> out = new Stack<>();

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.push(1);
        queue.push(2);
        int pop = queue.pop();
        System.out.println(pop);
    }

    public void push(int data) {
        in.push(data);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
