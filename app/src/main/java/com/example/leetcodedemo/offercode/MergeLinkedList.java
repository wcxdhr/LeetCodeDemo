package com.example.leetcodedemo.offercode;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

/**
 * Created by wcxdhr on 2020-02-10.
 */
public class MergeLinkedList {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 这道题写的不错，注意哑节点的设置
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dumbNode = new ListNode(0);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode mergeNode = dumbNode;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                mergeNode.next = p1;
                p1 = p1.next;
            }
            else {
                mergeNode.next = p2;
                p2 = p2.next;
            }
            mergeNode = mergeNode.next;
        }
        if (p1 != null)
            mergeNode.next = p1;
        else if (p2 != null)
            mergeNode.next = p2;
        return dumbNode.next;
    }
}
