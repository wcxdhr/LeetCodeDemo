package com.example.leetcodedemo.LinkedList.medium;
/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/9.
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode partition(ListNode head, int x) {
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode pre = dumb;
        while (pre.next != null && pre.next.val < x)
            pre = pre.next;
        head = pre;
        while (head.next != null) {
            if (head.next.val < x) {
                ListNode tmp = head.next;
                head.next = head.next.next;
                tmp.next = pre.next;
                pre.next = tmp;
                pre = pre.next;
            }
            else
                head = head.next;
        }
        return dumb.next;
    }
}
