package com.example.leetcodedemo.offercode;
/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wcxdhr on 2020-02-23.
 */
public class PrintZofTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 和书上思路相同，用两个栈来存储节点
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                if (node.left != null) stack2.push(node.left);
                if (node.right != null) stack2.push(node.right);
            }
            ans.add(new ArrayList<Integer>(list));
            list.clear();
            while (!stack2.empty()) {
                TreeNode node = stack2.pop();
                list.add(node.val);
                if (node.right != null) stack1.push(node.right);
                if (node.left != null) stack1.push(node.left);
            }
            if (list.size() > 0)
                ans.add(list);
        }
        return ans;
    }
}
