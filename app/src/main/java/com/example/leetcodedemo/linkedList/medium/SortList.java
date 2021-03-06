package com.example.leetcodedemo.linkedList.medium;
/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * Created by Wcxdhr on 2019/10/9.
 */
public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 更优解法/考核点：归并排序
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] arr = new int[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            arr[i] = cur.val;
            cur = cur.next;
        }
        Arrays.sort(arr);
        cur = head;
        for (int i = 0; i < len; i++) {
            cur.val = arr[i];
            cur = cur.next;
        }
        return head;
    }

    /**
     * 2020.3.29更新归并排序
     * 注意快慢指针的初始化，可以去掉哑节点，而是让slow = head，fast = head.next;
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p2 = slow.next;
        slow.next = null;
        head = sortList(head);
        p2 = sortList(p2);
        head = merge(head, p2);
        return head;
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dumb = new ListNode(-1);
        ListNode prev = dumb;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                prev.next = p1;
                p1 = p1.next;
            }
            else {
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        prev.next = p1 == null ? p2 : p1;
        return dumb.next;
    }
}
