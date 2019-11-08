package com.example.leetcodedemo.linkedList.medium;
/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/8.
 */
public class RemoveDuplicatesfromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 变量命名示例:当前节点cur
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        head = dumb;
        while (head.next != null && head.next.next != null) {
            ListNode node = head.next;
            if (node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val)
                    node = node.next;
                head.next = node.next;
            }
            else
                head = head.next;
        }
        return dumb.next;
    }
}
