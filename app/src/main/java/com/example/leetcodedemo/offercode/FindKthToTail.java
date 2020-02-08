package com.example.leetcodedemo.offercode;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

/**
 * Created by wcxdhr on 2020/2/8.
 */

public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 典型双指针，但是有许多边界条件需要考虑，
     * k小于等于0，及k大于链表长度，要仔细考虑
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (k <= 0)
            return null;
        ListNode p = head;
        for (int i = 1; i < k; i++) {
            if (p == null)
                return null;
            p = p.next;
        }
        if (p == null)
            return null;
        ListNode q = head;
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        return q;
    }
}
