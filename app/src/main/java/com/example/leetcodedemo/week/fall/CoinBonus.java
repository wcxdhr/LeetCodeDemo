package com.example.leetcodedemo.week.fall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wcxdhr on 2019/9/24.
 */

public class CoinBonus {

    public static void main(String[] args) {
        CoinBonus bonus = new CoinBonus();
        int[][] leadership = new int[][]{{1,2},{1,6},{2,3},{2,5}};
    }

    private static int MOD = 1000000007;

    public class TreeNode {
        int val;
        int sum;
        int lastUpdate;
        List<Integer> children = new ArrayList<>();
    }
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        TreeNode[] tree = new TreeNode[n + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = new TreeNode();
        }
        for (int i = 0; i < leadership.length; i++) {
            tree[leadership[i][0]].children.add(leadership[i][1]);
        }
        int count = 0;
        for (int[] operation : operations) {
            if (operation[0] == 3)
                count++;
        }
        int[] ans = new int[count];
        count = 0;
        int i = 0;
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                tree[operation[1]].val += operation[2];
            }
            else if (operation[0] == 2) {
                leetCoin(tree, operation[1], operation[2]);
            }
            else {
                ans[count++] = queryBonus(tree, operation[1], i);
            }
            i++;
        }
        return ans;
    }

    private void leetCoin(TreeNode[] tree, int i, int bonus) {
        tree[i].val += bonus;
        for (Integer child : tree[i].children) {
            leetCoin(tree, child, bonus);
        }
    }

    private int queryBonus(TreeNode[] tree, int i, int update) {
        if (update == tree[i].lastUpdate + 1)
            return tree[i].sum;
        int sum = tree[i].val;
        for (Integer child : tree[i].children)
            sum = (sum + queryBonus(tree, child, update)) % MOD;
        tree[i].sum = sum;
        tree[i].lastUpdate = update;
        return sum;
    }
}
