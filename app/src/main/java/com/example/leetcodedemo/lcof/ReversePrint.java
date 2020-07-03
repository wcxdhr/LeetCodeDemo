package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 通过次数44,998提交次数59,244
 */

import java.util.List;

/**
 * Created by wcxdhr on 2020-06-20.
 */
public class ReversePrint {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 在编写代码前，要跟面试官沟通清楚，根据面试官提出的不同性能需求
     * （时间效率优先 or 空间效率优先 or 不允许改变链表结构 or 云云），
     * 给出不同的算法。
     *
     *
     * 想到的直接修改链表反转了，其实如果不能修改链表的话应该用其他解法较好，例如递归和辅助栈
     * 归纳：若限制空间复杂度，直接翻转链表（翻转技巧：pre head next三个节点依次往后）或递归
     * 若限制不能动链表，则使用辅助栈和递归。
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            len++;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = pre.val;
            pre = pre.next;
        }
        return ans;
    }
}
