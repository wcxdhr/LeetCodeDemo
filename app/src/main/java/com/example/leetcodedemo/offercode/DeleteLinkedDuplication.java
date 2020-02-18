package com.example.leetcodedemo.offercode;
/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

/**
 * Created by wcxdhr on 2020-02-18.
 */
public class DeleteLinkedDuplication {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 好好分析就行，构造哑节点。
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dumbHead = new ListNode(-1);
        dumbHead.next = pHead;
        ListNode p = pHead;
        ListNode pre = dumbHead;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val)
                    p = p.next;
                pre.next = p.next;
                p = p.next;
            }
            else {
                pre = p;
                p = p.next;
            }
        }
        return dumbHead.next;
    }
}
