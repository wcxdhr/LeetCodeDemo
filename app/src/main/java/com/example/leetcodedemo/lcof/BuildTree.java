package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

/**
 * Created by wcxdhr on 2020-06-20.
 */
public class BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 递归解法：非常经典和传统
     * 官方解答还提供了迭代法，使用栈来做存储。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildHelper(int[] preorder, int[] inorder, int preS, int preE, int inS, int inE) {
        if (preS > preE)
            return null;
        int nodeIndex = inS;
        while (inorder[nodeIndex] != preorder[preS])
            nodeIndex++;
        TreeNode node = new TreeNode(preorder[preS]);
        node.left = buildHelper(preorder, inorder, preS + 1, preS + nodeIndex - inS, inS, nodeIndex - 1);
        node.right = buildHelper(preorder, inorder, preS + nodeIndex - inS + 1, preE, nodeIndex + 1, inE);
        return node;
    }
}
