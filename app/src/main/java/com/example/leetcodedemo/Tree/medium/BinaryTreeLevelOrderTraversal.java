package com.example.leetcodedemo.Tree.medium;
/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Wcxdhr on 2019/10/29.
 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 递归写法
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null)
            levelHelper(root, 0);
        return ans;
    }

    private void levelHelper(TreeNode node, int depth) {
        if (ans.size() == depth) {
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        ans.get(depth).add(node.val);
        if (node.left != null)
            levelHelper(node.left, depth + 1);
        if (node.right != null)
            levelHelper(node.right, depth + 1);
    }

    /**
     * 迭代写法
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                ans.add(new ArrayList<Integer>());
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.remove();
                    ans.get(ans.size() - 1).add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }

            }
        }
        return ans;
    }
}
