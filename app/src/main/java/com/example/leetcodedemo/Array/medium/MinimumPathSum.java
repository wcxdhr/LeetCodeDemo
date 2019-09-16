package com.example.leetcodedemo.Array.medium;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * Created by Wcxdhr on 2019/9/11.
 */
public class MinimumPathSum {

    /**
     * 可简化为动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[][] dis = new int[grid.length][grid[0].length];
        return miniDis(dis, grid, 0, 0);
    }

    private int miniDis(int[][] dis, int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;
        else if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];
        else if (dis[row][col] == 0)
            dis[row][col] = Math.min(miniDis(dis, grid, row + 1, col), miniDis(dis, grid, row, col + 1)) + grid[row][col];
        return dis[row][col];
    }
}
