package com.example.leetcodedemo.offercode;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;

/**
 * Created by wcxdhr on 2020-02-11.
 */
public class MinStack {


    /**
     * 这道题可以不用写这么复杂。
     * 书上官方解答：一个辅助栈，每次在辅助栈中只更新最小值，而不是存储所有的入栈元素。
     * 然后每次出栈的时候同步出栈。
     * 牛客上还有更好的解答，不开辟辅助栈，而是只记载最小值min和top值，
     * 入栈时记录value-min差值，出栈时对两个值进行更新
     */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> helpStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (minStack.empty() || node <= minStack.peek())
            minStack.push(node);
        else {
            while (!minStack.empty() && node > minStack.peek()) {
                helpStack.push(minStack.pop());
            }
            minStack.push(node);
            while (!helpStack.empty())
                minStack.push(helpStack.pop());
        }
    }

    public void pop() {
        if (!stack.empty()) {
            int node = stack.pop();
            while (minStack.peek() != node)
                helpStack.push(minStack.pop());
            minStack.pop();
            while (!helpStack.empty())
                minStack.push(helpStack.pop());
        }

    }

    public int top() {
        if (!stack.empty())
            return stack.peek();
        return 0;
    }

    public int min() {
        if (!stack.empty())
            return minStack.peek();
        return 0;
    }

}
