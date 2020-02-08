package com.example.leetcodedemo.offercode;
/**
 *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

/**
 * Created by wcxdhr on 2020/2/8.
 */

public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
//        ReConstructBinaryTree.reConstructBinaryTree(pre,in);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 边界条件，注意看为空的判断条件是什么
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructHelper(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructHelper(int[] pre, int[] in, int preStart, int preEnd, int inStart,int inEnd) {
        if (preEnd - preStart < 0)
            return null;
        TreeNode node = new TreeNode(pre[preStart]);
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart])
                break;
        }
        int len = i - inStart;
        node.left = reConstructHelper(pre, in, preStart + 1, preStart + len, inStart, i - 1);
        node.right = reConstructHelper(pre, in, preStart + len + 1, preEnd, i + 1, inEnd);
        return node;
    }

}
