package com.example.leetcodedemo.interview.ali.exam.one;

import java.util.Scanner;

/**
 * Created by wcxdhr on 2020-03-21.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        long[][] matrix = new long[n][m];
        int[] rowsFlag = new int[n];
        int[] colFlag = new int[m];
        boolean[] rowShow = new boolean[n];
        boolean[] colShow = new boolean[m];
        for (int i = 0; i < n; i++) {
            int start = -1;
            int end = -1;
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] != 0) {
                    rowsFlag[i]++;
                    colFlag[j]++;
                    if (start == -1) {
                        start = j;
                    }
                    else if (end == -1) {
                        end = j;
                    }
                }
            }
            if (rowsFlag[i] >= 2) {
                long dis = (matrix[i][end] - matrix[i][start]) / (end - start);
                if (matrix[i][0] == 0)
                    matrix[i][0] = matrix[i][start] - dis * start;
                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = matrix[i][j - 1] + dis;
                        colFlag[j]++;
                    }
                }
                rowShow[i] = true;
            }

        }
        for (int j = 0; j < m; j++) {
            if (colFlag[j] >= 2) {
                int start = -1;
                int end = -1;
                for (int i = 0; i < n; i++) {
                    if (matrix[i][j] != 0) {
                        if (start == -1) {
                            start = j;
                        }
                        else if (end == -1) {
                            end = j;
                            break;
                        }
                    }
                }
                long dis = (matrix[end][j] - matrix[start][j]) / (end - start);
                if (matrix[0][j] == 0)
                    matrix[0][j] = matrix[start][j] - dis * start;
                for (int i = 1; i < n; i++) {
                    if (matrix[i][j] == 0)
                        matrix[i][j] = matrix[i - 1][j] + dis;
                }
                colShow[j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (rowsFlag[i] >= 2 && !rowShow[i]) {
                int start = -1;
                int end = -1;
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] != 0) {
                        if (start == -1) {
                            start = j;
                        }
                        else if (end == -1) {
                            end = j;
                            break;
                        }
                    }
                }
                long dis = (matrix[i][end] - matrix[i][start]) / (end - start);
                if (matrix[i][0] == 0)
                    matrix[i][0] = matrix[i][start] - dis * start;
                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = matrix[i][j - 1] + dis;
                        colFlag[j]++;
                    }
                }
            }
        }


        for (int j = 0; j < m; j++) {
            if (rowsFlag[j] >= 2 && !rowShow[j]) {
                int start = -1;
                int end = -1;
                for (int i = 0; i < n; i++) {
                    if (matrix[i][j] != 0) {
                        if (start == -1) {
                            start = j;
                        }
                        else if (end == -1) {
                            end = j;
                            break;
                        }
                    }
                }
                long dis = (matrix[end][j] - matrix[start][j]) / (end - start);
                if (matrix[0][j] == 0)
                    matrix[0][j] = matrix[start][j] - dis * start;
                for (int i = 1; i < n; i++) {
                    if (matrix[i][j] == 0)
                        matrix[i][j] = matrix[i - 1][j] + dis;
                }
            }
        }

        while (q-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (matrix[x][y] != 0)
                System.out.println(matrix[x][y]);
            else
                System.out.println("UnKnown");
        }

        System.out.println(" ");
    }

    private static void showMatrix(long[][] matrix, int n, int m, int x, boolean rowF) {
        if (rowF) {

        }
    }
}
