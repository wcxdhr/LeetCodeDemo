package com.example.leetcodedemo.offercode;
/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

/**
 * Created by wcxdhr on 2020-02-20.
 */
public class TreeisSymmetrical {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 这题比较简单，递归比较即可
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot != null)
            return symmetricalHelper(pRoot.left, pRoot.right);
        return true;
    }

    private boolean symmetricalHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            else return symmetricalHelper(left.left, right.right) &&
                    symmetricalHelper(left.right, right.left);
        }
        return false;
    }
}
