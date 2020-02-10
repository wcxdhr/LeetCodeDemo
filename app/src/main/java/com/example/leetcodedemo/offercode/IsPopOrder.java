package com.example.leetcodedemo.offercode;
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

import java.util.Stack;

/**
 * Created by wcxdhr on 2020-02-10.
 */
public class IsPopOrder {

    public static void main(String[] args) {
        System.out.println(new IsPopOrder().IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }

    /**
     * 思路：要用辅助栈来模拟弹出站，一个栈来压入，一个来弹出。
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        int len = popA.length;
        if (len == 0)
            return true;
        stack.push(pushA[i++]);
        while (j < len) {
            while (stack.peek() != popA[j]) {
                if (i == len)
                    return false;
                stack.push(pushA[i++]);
            }
            stack.pop();
            j++;
        }
        return true;
    }
}
