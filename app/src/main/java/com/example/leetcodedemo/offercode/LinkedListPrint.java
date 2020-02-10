package com.example.leetcodedemo.offercode;
/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wcxdhr on 2020/2/5.
 */

public class LinkedListPrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < 6; i++) {
            ListNode next = new ListNode(i);
            p.next = next;
            p = p.next;
        }
        System.out.println(new LinkedListPrint().printListFromTailToHead(head));
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 书上的意思是要逆序打印，这个要想到栈，链表和栈
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.empty()) {
            ans.add(stack.pop().val);
        }
        return ans;
    }

    /**
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        list.add(listNode.val);
        ListNode p = listNode.next;
        while (p != null) {
            list.add(0, p.val);
            p = p.next;
        }
        return list;
    }
}
