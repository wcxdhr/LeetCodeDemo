package com.example.leetcodedemo.LinkedList.medium;
/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import org.w3c.dom.ls.LSException;

/**
 * Created by Wcxdhr on 2019/10/9.
 */
public class AddTwoNumbersII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode cur = l1;
        while (cur != null){
            cur = cur.next;
            len1++;
        }
        cur = l2;
        while (cur != null) {
            cur = cur.next;
            len2++;
        }
        while (len2 < len1) {
            ListNode tmp = new ListNode(0);
            tmp.next = l2;
            l2 = tmp;
            len2++;
        }
        while (len1 < len2) {
            ListNode tmp = new ListNode(0);
            tmp.next = l1;
            l1 = tmp;
            len1++;
        }
        if (addNumberHelper(l1, l2) == 1) {
            ListNode tmp = new ListNode(1);
            tmp.next = l1;
            l1 = tmp;
        }
        return l1;
    }

    private int addNumberHelper(ListNode l1, ListNode l2) {
        if (l1 != null){
            l1.val = l1.val + l2.val + addNumberHelper(l1.next, l2.next);
            if (l1.val > 9) {
                l1.val = l1.val % 10;
                return 1;
            }
        }
        return 0;
    }
}
