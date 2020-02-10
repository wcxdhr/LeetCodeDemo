package com.example.leetcodedemo.offercode;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wcxdhr on 2020-02-10.
 */
public class PrintTreeFromTopToBottom {


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
        System.out.println(PrintFromTopToBottom(root1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 典型的层次遍历啊
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            ans.add(node.val);
        }
        return ans;
    }
}
