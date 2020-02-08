package com.example.leetcodedemo.offercode;
/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

/**
 * Created by wcxdhr on 2020/2/8.
 */

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 可以参考我在leetcode上写的，设置哑节点，为空，前一个是prev，中间是p，后面是next
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head;
        ListNode next = p.next;
        ListNode secondNext;
        while (next != null) {
            secondNext = next.next;
            next.next = p;
            p = next;
            next = secondNext;
        }
        head.next = null;
        return p;
    }
}
