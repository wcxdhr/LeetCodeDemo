package com.example.leetcodedemo.offercode;
/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */

/**
 * Created by wcxdhr on 2020-02-22.
 */
public class KthNodeofSearchTree {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路：中序遍历，给一个变量来记录遍历进度，可行。
     */
    private int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null)
            return null;
        TreeNode left = KthNode(pRoot.left, k);
        if (count == k)
            return left;
        count++;
        if (count == k)
            return pRoot;
        TreeNode right = KthNode(pRoot.right, k);
        if (count == k)
            return right;
        return null;
    }
}
