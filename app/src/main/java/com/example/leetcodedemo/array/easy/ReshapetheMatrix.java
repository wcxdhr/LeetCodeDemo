package com.example.leetcodedemo.array.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class ReshapetheMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4)));
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c)
            return nums;
        int[][] ans = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[x][y++];
                if (y > nums[0].length - 1) {
                    x++;
                    y = 0;
                }
            }
        }
        return ans;
    }
}
