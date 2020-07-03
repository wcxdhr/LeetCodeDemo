package com.example.leetcodedemo.offercode;
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、
 * 层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wcxdhr on 2020-02-27.
 */
public class TreeSerializeandDeserialize {


    public static void main(String[] args) {
        TreeSerializeandDeserialize deserialize = new TreeSerializeandDeserialize();
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
        String s = deserialize.Serialize(root1);
        System.out.println(s);
        System.out.println(deserialize.Deserialize(s));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        String ans = "";
        if (root == null)
            return ans;
        queue.add(root);
        ans += (root.val + "!");
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                ans += (node.left.val + "!");
                queue.add(node.left);
            }
            else {
                ans += "#!";
            }
            if (node.right != null){
                ans += (node.right.val + "!");
                queue.add(node.right);
            }
            else {
                ans += "#!";
            }
        }
        return ans;
    }
    TreeNode Deserialize(String str) {
        TreeNode root = null;
        if (str.length() == 0)
            return root;
        int count = 1, nextCount = 0;
        String[] split = str.split("!");
        root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < split.length && !queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (!split[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            i++;
            if (!split[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i++;

        }
        return root;
    }
}
