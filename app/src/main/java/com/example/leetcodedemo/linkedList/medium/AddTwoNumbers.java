package com.example.leetcodedemo.linkedList.medium;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/27.
 */
public class AddTwoNumbers {


    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansNode = new ListNode(0);
        ListNode p = ansNode;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int plus = 0;
        while (p1 != null || p2 != null) {
            ListNode n = new ListNode(0);
            p.next = n;
            p = n;
            n.val = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + plus;
            if (n.val > 9) {
                n.val = n.val % 10;
                plus = 1;
            }
            else plus = 0;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (plus == 1) {
            ListNode n = new ListNode(1);
            p.next = n;
        }
        return ansNode.next;
    }
}
