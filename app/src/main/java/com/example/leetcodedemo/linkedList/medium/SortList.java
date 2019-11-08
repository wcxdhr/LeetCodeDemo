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
    public ListNode sortList(ListNode head) {
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
}
