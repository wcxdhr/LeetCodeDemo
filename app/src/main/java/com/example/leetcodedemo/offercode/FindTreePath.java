package com.example.leetcodedemo.offercode;
/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;

/**
 * Created by wcxdhr on 2020-02-13.
 */
public class FindTreePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    /**
     * leetcode上有原题,注意list可以这样clone：ArrayList<Integer> sub = new ArrayList<>(list);
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return ans;
        pathHelper(root, target, new ArrayList<Integer>());
        return ans;
    }

    private void pathHelper(TreeNode node, int target, ArrayList<Integer> list) {
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                ArrayList<Integer> sub = new ArrayList<>(list);
                sub.add(node.val);
                ans.add(sub);
            }
        }
        else {
            list.add(node.val);
            if (node.left != null)
                pathHelper(node.left, target - node.val, list);
            if (node.right != null)
                pathHelper(node.right, target - node.val, list);
            list.remove(list.size() - 1);
        }

    }
}
