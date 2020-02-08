package com.example.leetcodedemo.offercode;

/**
 * Created by wcxdhr on 2020/2/2.
 */

public class Solution {


    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode p = head;
        for (int i = 2; i < 6; i++) {
            RandomListNode next = new RandomListNode(i);
            p.next = next;
            p = p.next;
        }
        head.random = head.next;
        p = head.next;
        p.random = head;
        p = p.next;
        p.random = head.random;
        p = p.next;
        p.random = head.next;
        p = p.next;
        p.random = p;
        p = Clone(head);
    }


    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = pHead;
        RandomListNode origHead = head;
        RandomListNode q = new RandomListNode(head.label);
        RandomListNode cpHead = q;
        head = head.next;
        // copy node
        while (head != null) {
            RandomListNode current = new RandomListNode(head.label);
            q.next = current;
            q = current;
            head = head.next;
        }

        // System.out.println(cpHead);
        // link
        head = origHead;
        q = cpHead;
        while (head != null) {
            RandomListNode origNext = head.next;
            RandomListNode cpNext = q.next;
            head.next = q;
            q.next = origNext;

            head = origNext;
            q = cpNext;
        }
//        System.out.println(origHead);

        // copy random
        head = origHead;
        q = cpHead;
        while (head != null) {
            if (head.random != null) {
                q.random = head.random.next;
            }
            if (head.next.next != null) {
                head = head.next.next;
                q = head.next;
            } else {
                break;
            }
        }

        // unlink
        head = origHead;
        q = cpHead;
        while (q != null && head != null) {
            RandomListNode origNext = q.next;
            RandomListNode cpNext = null;
            if (origNext != null) {
                cpNext = origNext.next;
            }

            head.next = origNext;
            q.next = cpNext;

            head = origNext;
            q = cpNext;
        }
        return cpHead;


    }
}
