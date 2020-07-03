package com.example.leetcodedemo.restof200.easy;
/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

/**
 * Created by wcxdhr on 2020-03-21.
 */

import java.util.Stack;

/**
 * 剑指offer上面的题
 */
public class MinStack {
    /** initialize your data structure here. */

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack =new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //isEmpty是线程安全的(Vector的方法）  empty不是
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        else minStack.push(minStack.peek());
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return 0;
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
