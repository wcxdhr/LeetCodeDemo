package com.example.leetcodedemo.offercode;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/**
 * Created by wcxdhr on 2020-02-21.
 */
public class GetNextNodeofTree {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：分了两种情况
     * 1.节点有右子树：则下一个节点就是右子树的最左边的节点
     * 2.节点无右子树：则下一个节点为父节点中的第一个将该节点作为左子树的节点
     * 否者没有下一个节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        else {
            TreeLinkNode node = pNode;
            while (node != null && node.next != null) {
                if (node.next.left == node)
                    return node.next;
                node = node.next;
            }
            return null;
        }
    }
}
