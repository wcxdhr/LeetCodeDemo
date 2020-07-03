package com.example.leetcodedemo.linkedList.medium;
/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/8.
 */
public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode preM = dumb;
        ListNode nodeM;
        int i = 1;
        while (i < m) {
            i++;
            preM = preM.next;
        }
        ListNode preNode =  nodeM = preM.next;
        //head来进行遍历，其实可以改成cur
        head = preNode.next;
        while (i < n) {
            i++;
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        preM.next = preNode;
        nodeM.next = head;
        return dumb.next;
    }
}
