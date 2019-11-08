package com.example.leetcodedemo.tree.medium;
/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Wcxdhr on 2019/10/30.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 优化：可以用队列，添加时addfirst即可
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> pos = new Stack<>();
        Stack<TreeNode> neg = new Stack<>();
        if (root != null) {
            pos.add(root);
            boolean posFlag = true;
            while (!pos.isEmpty() || !neg.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                if (posFlag) {
                    while (!pos.isEmpty()) {
                        TreeNode node = pos.pop();
                        if (node.left != null)
                            neg.add(node.left);
                        if (node.right != null)
                            neg.add(node.right);
                        list.add(node.val);
                    }
                }
                else {
                    while (!neg.isEmpty()) {
                        TreeNode node = neg.pop();
                        if (node.right != null)
                            pos.add(node.right);
                        if (node.left != null)
                            pos.add(node.left);
                        list.add(node.val);
                    }
                }
                posFlag = !posFlag;
                ans.add(list);
            }
        }
        return ans;
    }
}
