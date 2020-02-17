package com.example.leetcodedemo.offercode;
/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */


/**
 * Created by wcxdhr on 2020-02-15.
 */
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * leetcpde原题，就是先遍历出长度，再第二次遍历，找相同节点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        ListNode p1 = pHead1;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        int len2 = 0;
        ListNode p2 = pHead2;
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        while (pHead1 != null && pHead2 != null) {
            while (len1 > len2) {
                pHead1 = pHead1.next;
                len1--;
            }
            while (len2 > len1) {
                pHead2 = pHead2.next;
                len2--;
            }
            if (pHead1 == pHead2)
                return pHead1;
            else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
