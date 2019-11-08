package com.example.leetcodedemo.linkedList.medium;
/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/10.
 */
public class ConvertSortedListtoBinarySearchTree {

     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode sortedListToBST(ListNode head) {
         if (head == null)
             return null;
        ListNode slow = head;
        ListNode fast = head;
        TreeNode pre = new TreeNode(head.val);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            TreeNode node = new TreeNode(slow.val);
            node.left = pre;
            pre = node;
        }
        TreeNode tree = pre;
        while (slow.next != null) {
            slow = slow.next;
            pre.right = new TreeNode(slow.val);
             pre = pre.right;
        }
        return tree;
    }
}
