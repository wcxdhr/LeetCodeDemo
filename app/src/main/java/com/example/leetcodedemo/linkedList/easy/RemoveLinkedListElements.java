package com.example.leetcodedemo.linkedList.easy;
/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

/**
 * Created by Wcxdhr on 2019/10/8.
 */
public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode node = dumb;
        while (node.next != null) {
           if (node.next.val == val)
               node.next = node.next.next;
           else node = node.next;
        }
        return dumb.next;
    }
}
