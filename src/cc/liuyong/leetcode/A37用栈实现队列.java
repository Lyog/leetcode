package cc.liuyong.leetcode;

import java.util.Stack;

public class A37用栈实现队列 {
    private Stack<Integer> outStack;
    private Stack<Integer> inStack;

    public A37用栈实现队列() {
        outStack = new Stack<>();
        inStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) inToOut();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) inToOut();
        return outStack.peek();
    }

    // 当 outStack 和 inStack 中的元素均为空的时候，模拟队列才为空
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    // 转移元素
    private void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
