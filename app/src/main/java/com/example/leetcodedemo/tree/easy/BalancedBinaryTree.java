package com.example.leetcodedemo.tree.easy;
/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/11/1.
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 优化：深度不为负数，可以使用-1来标记false，去掉全局变量
     */
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        balanceHelper(root);
        return flag;
    }

    private int balanceHelper(TreeNode node) {
        if (flag) {
            if (node == null)
                return 0;
            if (node.left == null && node.right == null)
                return 1;
            else {

                int l = balanceHelper(node.left);
                int r = balanceHelper(node.right);
                if (Math.abs(l - r) > 1)
                    flag = false;
                else
                    return Math.max(l, r);
            }
        }
        return 0;
    }
}
