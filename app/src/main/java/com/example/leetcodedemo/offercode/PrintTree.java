package com.example.leetcodedemo.offercode;
/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wcxdhr on 2020-02-22.
 */
public class PrintTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 和书上思路相同，就是给两个变量，一个记录当前行的节点数，一个记录下一行的节点数
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null)
            queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            count--;
            if (node.left != null) {
                queue.add(node.left);
                nextCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextCount++;
            }
            if (count == 0) {
                ans.add(new ArrayList<Integer>(list));
                list.clear();
                count = nextCount;
                nextCount = 0;
            }
        }
        return ans;
    }
}
