package com.example.leetcodedemo.offercode;
/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

/**
 * Created by wcxdhr on 2020-02-13.
 */
public class TreeDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 这倒题比较简单，直接递归，如果非递归的话参考层次遍历，用队列来实现
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        else return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
