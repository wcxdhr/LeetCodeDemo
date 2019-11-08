package com.example.leetcodedemo.tree.medium;
/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/11/8.
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null)
            sumHelper(root, sum, new ArrayList<Integer>());
        return ans;
    }

    private void sumHelper(TreeNode node, int sum, List<Integer> list) {
        if (node.left == null && node.right == null && sum == node.val) {
            list.add(node.val);
            List<Integer> sub = new ArrayList<>(list);
            ans.add(sub);
            list.remove(list.size() - 1);
        }
        else {
            list.add(node.val);
            if (node.left != null)
                sumHelper(node.left, sum - node.val, list);
            if (node.right != null)
                sumHelper(node.right, sum - node.val, list);
            list.remove(list.size() - 1);
        }
    }
}
