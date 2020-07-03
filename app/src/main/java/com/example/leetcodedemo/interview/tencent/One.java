package com.example.leetcodedemo.interview.tencent;
/**
 * ```
 * // 两个大数相加
 * class Node{
 *     int val;
 *     Node next;
 * }
 *
 * public Node add(Node headA, Node headB) {
 *
 * }
 * 例：
 * 1 -> 2 -> 5
 * 4 -> 3
 * ```
 */

/**
 * Created by wcxdhr on 2020-03-24.
 */
public class One {

    public static void main(String[] args){

    }

    class Node{
     int val;
     Node next;
 }

    public Node add(Node headA, Node headB) {
        headA = reverse(headA);
        headB = reverse(headB);
        Node dumbHead = new Node();
        Node prev = dumbHead;
        Node cur = new Node();
        int plus = 0;
        while (headA != null && headB != null) {
            int sum = headA.val + headB.val + plus;
            if (sum > 9) {
                sum %= 10;
                plus = 1;
            }
            else plus = 0;
            cur.val = sum;
            prev.next = cur;
            prev = cur;
            cur.next = new Node();
            cur = cur.next;
            headA = headA.next;
            headB = headB.next;
        }
        while (headA != null) {
            int sum = headA.val + plus;
            if (sum > 9) {
                sum %= 10;
                plus = 1;
            }
            else plus = 0;
            cur.val = sum;
            prev.next = cur;
            prev = cur;
            cur.next = new Node();
            cur = cur.next;
            headA = headA.next;
        }
        while (headB != null) {
            int sum = headB.val + plus;
            if (sum > 9) {
                sum %= 10;
                plus = 1;
            }
            else plus = 0;
            cur.val = sum;
            prev.next = cur;
            prev = cur;
            cur.next = new Node();
            cur = cur.next;
            headB = headB.next;
        }
        if (plus == 1) {
            cur.val = 1;
            cur.next = new Node();
            cur = cur.next;
        }
        prev.next = null;
        Node sumHead = dumbHead.next;
        dumbHead = null;
        return reverse(sumHead);
    }

    private Node reverse(Node head) {
        Node p = head;
        Node prev = null;
        while (p != null) {
            Node nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return prev;
    }

}
