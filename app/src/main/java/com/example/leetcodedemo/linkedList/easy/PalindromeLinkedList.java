package com.example.leetcodedemo.linkedList.easy;
/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/30.
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 更优解法：快慢指针，一半链表倒置
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] arr = new int[len / 2];
        node = head;
        int i = 0;
        while (i < arr.length) {
            arr[i++] = node.val;
            node = node.next;
        }
        if ((len & 1) == 1)
            node = node.next;
        while (node != null) {
            if (arr[--i] != node.val)
                return false;
            node = node.next;
        }
        return true;
    }
}
