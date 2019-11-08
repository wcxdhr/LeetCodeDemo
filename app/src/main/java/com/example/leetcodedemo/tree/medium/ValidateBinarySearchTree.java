package com.example.leetcodedemo.tree.medium;
/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/10/29.
 */
public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历升序
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        boolean flag = true;
        if (root != null) {
            if (root.left != null)
                flag = isValidBST(root.left);
            if (!list.isEmpty() && list.get(list.size() - 1) >= root.val)
                return false;
            else
                list.add(root.val);
            if (root.right != null)
                flag = flag && isValidBST(root.right);
        }
        return flag;
    }

    /**
     * 官方解答：传递一个lower和一个upper参数，省去了List，效率更优
     * @param
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }
}
