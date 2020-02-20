package com.example.leetcodedemo.offercode;
/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

import java.util.List;

/**
 * Created by wcxdhr on 2020-02-19.
 */
public class EntryNodeOfLoopLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 7; i++) {
            ListNode next = new ListNode(i);
            p.next = next;
            p = p.next;
        }
        p.next = head.next.next;

        EntryNodeOfLoop(head);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 书上的思路比较好理解：
     * 先判断是否有环-》在相遇的地点再循环一圈得到环的长度-》
     * 两个指针从头出发，一个先走环的长度，两个在一起走，相遇的地点便是入环节点
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null) return null;
        int n = 1;
        do {
            slow = slow.next;
            n++;
        } while (slow != fast);
        fast = slow = pHead;
        while (n != 1) {
            fast = fast.next;
            n--;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
