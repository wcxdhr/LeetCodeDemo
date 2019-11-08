package com.example.leetcodedemo.array.medium;
/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

/**
 * Created by Wcxdhr on 2019/9/19.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    HashMap<Integer, Integer> in = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            in.put(inorder[i], i);
        return buildTreeHelper(inorder, postorder, 0, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int postStart, int len) {
        if (len > 0) {
            TreeNode node = new TreeNode(postorder[postStart + len - 1]);
            if (len > 1) {
                int inIndex = in.get(node.val);
                node.left = buildTreeHelper(inorder, postorder, inStart, postStart, inIndex - inStart);
                node.right = buildTreeHelper(inorder, postorder, inIndex + 1, postStart + inIndex - inStart, inStart + len - inIndex - 1);
            }
            return node;
        }
        else return null;
    }
}
