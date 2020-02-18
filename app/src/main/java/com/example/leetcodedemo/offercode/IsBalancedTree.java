package com.example.leetcodedemo.offercode;
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

/**
 * Created by wcxdhr on 2020-02-18.
 */
public class IsBalancedTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * leetcode上有原题，一样的问题，去掉全局变量，用-1表示false
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (balanceHelper(root, 0) == -1)
            return false;
        return true;
    }

    private int balanceHelper(TreeNode node, int depth) {
        if (depth != - 1) {
            if (node == null)
                return depth;
            int leftDepth = balanceHelper(node.left, depth);
            int rightDepth = balanceHelper(node.right, depth);
            if (leftDepth == -1 || rightDepth == -1 || leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1)
                return -1;
            else
                return Math.max(leftDepth, rightDepth) + 1;
        }
        return depth;
    }
}
