package com.example.leetcodedemo.offercode;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/**
 * Created by wcxdhr on 2020-02-18.
 */
public class ConvertBinarySearchTreeToLinkedList {


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(14);
        root1.left = left;
        root1.right = right;
        TreeNode left1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(8);
        left.left = left1;
        left.right = right2;
        TreeNode left2 = new TreeNode(12);
        TreeNode right3 = new TreeNode(16);
        right.left = left2;
        right.right = right3;
        ConvertBinarySearchTreeToLinkedList.Convert(root1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode leftLast = null;

    /**
     * 思路重点：一个全局变量用于存储上一个节点，每次返回的都是最左边的节点。
     * @param pRootOfTree
     * @return
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return pRootOfTree;
        TreeNode left = null;
        if (pRootOfTree.left != null)
            left = Convert(pRootOfTree.left);
        if (left != null) {
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;
        TreeNode right = null;
        if (pRootOfTree.right != null)
            right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }

}
