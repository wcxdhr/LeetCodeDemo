package com.example.leetcodedemo.offercode;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 */

import java.util.Stack;

/**
 * Created by wcxdhr on 2020/2/6.
 * 这个题比较简单
 */

public class UseStackforQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty())
            return -1;
        else {
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
        int ans = stack2.pop();
        while (!stack2.empty())
            stack1.push(stack2.pop());
        return ans;
    }
}
