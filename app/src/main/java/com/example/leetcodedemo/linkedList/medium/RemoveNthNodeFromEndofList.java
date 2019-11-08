package com.example.leetcodedemo.linkedList.medium;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wcxdhr on 2019/9/29.
 */
public class RemoveNthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 更优解法：
     * 空间优化：使用双指针，去掉队列
     * 代码优化：设置哑节点，节点的next指针指向链表头部，不用再单独判断特殊情况。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode p = head;
        queue.add(p);
        while (p != null) {
            if (queue.size() == n + 1)
                queue.remove();
            queue.add(p);
            p = p.next;
        }
        if (queue.size() == n)
            return head.next;
        if (n == 0)
            return head;
        p = queue.element();
        p.next = p.next.next;
        return head;
    }

}
