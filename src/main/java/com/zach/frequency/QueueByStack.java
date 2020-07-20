package com.zach.frequency;

/**
 * @Classname QueueByStack
 * @Description: 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 * @Date 2020/7/18 15:21
 * @Author: Zach
 * @version: V1.0
 */
public class QueueByStack<T> {
    private LinkStack<T> in = new LinkStack<>();
    private LinkStack<T> out = new LinkStack<>();

    //进入队列
    public void push(T element) {
        in.push(element);
    }

    //出队
    public T pop() {
        while (!in.empty()) {
            out.push(in.pop());
        }
        return out.pop();
    }

    public static void main(String[] args) {

    }


}
