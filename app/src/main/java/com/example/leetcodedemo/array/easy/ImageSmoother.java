package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int[][] S = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int count = 0;
                int x = i - 1;
                while ( x < i + 2) {
                    int y = j - 1;
                    while (y < j + 2) {
                      if (x > -1 && y > -1 && x < M.length && y < M[0].length) {
                          S[i][j] += M[x][y];
                          count++;
                      }
                      y++;
                    }
                    x++;
                }
                S[i][j] /= count;
            }
        }
        return S;
    }
}
