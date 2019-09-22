package com.example.leetcodedemo.week.week154;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wcxdhr on 2019/9/15.
 */

public class two {

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    /**
     * 括号匹配：栈、队列
     * @param s
     * @return
     */
    public static String reverseParentheses(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
            Queue<Character> queueBak = new LinkedList<>();
        for (char c : charArr) {
            if (c != ')')
                stack.push(c);
            else {
                char tmp = stack.pop();
                while ( tmp != '(') {
                    queueBak.offer(tmp);
                    tmp = stack.pop();
                }
                while (!queueBak.isEmpty()) {
                    tmp = queueBak.poll();
                    stack.push(tmp);
                }
            }
        }
        char[] ansChar = new char[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            ansChar[i++] = stack.pop();
        }
        return new StringBuffer(new String(ansChar)).reverse().toString();
    }

}
