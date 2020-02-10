package com.example.leetcodedemo.offercode;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 * Created by wcxdhr on 2020-02-10.
 */
public class HasSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(7);
        root1.left = left;
        root1.right = right;
        TreeNode left1 = new TreeNode(9);
        TreeNode right2 = new TreeNode(2);
        left.left = left1;
        left.right = right2;
        TreeNode left2 = new TreeNode(4);
        TreeNode right3 = new TreeNode(7);
        right2.left = left2;
        right2.right = right3;
        HasSubtree.HasSubtree(root1, left);
    }

    /**
     * 他这个子结构和我想的不太一样啊，题目的意思是树的中间结构也是子结构，不一定root2要直到叶子结点。
     * 牛客也不给个测试用例，描述的不清楚。
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        if (subtreeHelper(root1, root2))
            return true;
        else return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private static boolean subtreeHelper(TreeNode root1,TreeNode root2) {
        if (root2 == null)
            return true;
        else if (root1 == null)
            return false;
        if (root1.val == root2.val)
            return subtreeHelper(root1.left, root2.left) && subtreeHelper(root1.right, root2.right);
        else
            return false;
    }
}
