package com.example.leetcodedemo.Array.medium;
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/19.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findTree(preorder, inorder, 0, 0, inorder.length);
    }

    private TreeNode findTree(int[] preorder, int[] inorder, int preLeft, int inleft, int len) {
        if (len == 1)
            return new TreeNode(preorder[preLeft]);
        else {
            TreeNode node = new TreeNode(preorder[preLeft]);
            int inIndex = inleft;
            for (int i = inleft; i < inleft + len; i++) {
                if (node.val == inorder[i]) {
                    inIndex = i;
                    break;
                }
            }
            node.left = findTree(preorder, inorder, preLeft + 1, inleft, inIndex - inleft);
            node.right = findTree(preorder, inorder, preLeft + 1 + inIndex - inleft, inIndex + 1, inleft + len - inIndex + 1);
            return node;
        }
    }
}
