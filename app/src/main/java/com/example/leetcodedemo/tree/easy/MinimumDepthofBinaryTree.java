package com.example.leetcodedemo.tree.easy;
/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/11/1.
 */
public class MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        depthHelper(root, 0);
        return minDepth;
    }

    private void depthHelper(TreeNode node, int depth) {
        if (depth == minDepth)
            return;
        if (node != null) {
            if (node.left == null && node.right == null)
                minDepth = Math.min(minDepth, depth + 1);
            else {
                if (node.left != null)
                    depthHelper(node.left, depth + 1);
                if (node.right != null)
                    depthHelper(node.right, depth + 1);
            }
        }
    }
}
