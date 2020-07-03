package com.example.leetcodedemo.interview.ali.exam.two;

import java.util.Scanner;

/**
 * Created by wcxdhr on 2020-03-21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        long[][] dp = new long[3][n];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                dp[i][j] = Math.min(Math.abs(a[i][j] - a[0][j - 1]) + dp[0][j - 1], Math.abs(a[i][j] - a[1][j - 1]) + dp[1][j - 1]);
                dp[i][j] = Math.min(Math.abs(a[i][j] - a[2][j - 1]) + dp[2][j - 1], dp[i][j]);
            }
        }
        long minDis = Math.min(dp[0][n - 1], dp[1][n - 1]);
        minDis = Math.min(dp[2][n - 1], minDis);
        System.out.println(minDis);
    }

}
