package com.example.leetcodedemo.offercode;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */

/**
 * Created by wcxdhr on 2020-02-10.
 */
public class MirrorTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 这道题也比较简单，直接递归就好了，总之都是注意细节
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }
}
