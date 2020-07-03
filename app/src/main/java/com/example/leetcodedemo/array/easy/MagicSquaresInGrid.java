package com.example.leetcodedemo.array.easy;
/**
 * 840. 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，
 * 每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *
 *
 * 示例：
 *
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class MagicSquaresInGrid {

    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]
                {       {9,9,5,1,9,5,5,7,2,5},
                        {9,1,8,3,4,6,7,2,8,9},
                        {4,1,1,5,9,1,5,9,6,4},
                        {5,5,6,7,2,8,3,4,0,6},
                        {1,9,1,8,3,1,4,2,9,4},
                        {2,8,6,4,2,7,3,2,7,6},
                        {9,2,5,0,7,8,2,9,5,1},
                        {2,1,4,4,7,6,2,4,3,8},
                        {1,2,5,3,0,5,10,8,5,2},
                        {6,9,6,8,8,4,3,6,0,9}}
        ));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                int[] nums = new int[10];
                boolean flag = false;
                if (grid[i + 1][j + 1] != 5)
                    continue;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (grid[i + x][j + y] > 9) {
                            flag = true;
                            break;
                        }
                        else
                            nums[grid[i + x][j + y]]++;
                    }
                    if (flag)
                        break;
                }
                for (int k = 1; k < nums.length; k++) {
                    if (nums[k] != 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    continue;
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15)
                    continue;
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15)
                    continue;
                int n = 0;
                for (int k = 0; k < 3; k++) {
                    if (grid[i][j + k] + grid[i + 1][j + k] + grid[i + 2][j + k] != 15)
                        break;
                    if (grid[i + k][j] + grid[i + k][j + 1] + grid[i + k][j + 2] != 15)
                        break;
                    n += 2;
                }
                if (n == 6) count++;

            }

        }
        return count;
    }
}
