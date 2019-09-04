package com.example.leetcodedemo.Array.easy;

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
