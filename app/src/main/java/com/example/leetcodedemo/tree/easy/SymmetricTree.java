package com.example.leetcodedemo.tree.easy;
/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wcxdhr on 2019/10/29.
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null || left.val != right.val)
            return false;
        else return symmetricHelper(left.left, right.right) && symmetricHelper(left.right, right.left);
    }

    /**
     * 迭代,优化：将队列改为一个
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        if (root.left == null || root.right == null)
            return false;
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();
        leftQ.add(root.left);
        rightQ.add(root.right);
        while (!leftQ.isEmpty() && !rightQ.isEmpty()) {
            TreeNode left = leftQ.remove();
            TreeNode right = rightQ.remove();
            if (left.val != right.val)
                return false;
            if (left.left != null && right.right != null) {
                leftQ.add(left.left);
                rightQ.add(right.right);
            }
            else if (left.left != null || right.right != null)
                return false;
            if (left.right != null && right.left != null) {
                rightQ.add(right.left);
                leftQ.add(left.right);
            }
            else if (left.right != null || right.left != null)
                return false;
        }
        return true;
    }
}
