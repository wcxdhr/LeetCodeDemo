package com.example.leetcodedemo.interview.kickstart.rounda;
/**
 *
 * 帕特尔博士有 n 堆盘子。 每个堆栈包含 k 盘。 每个盘子都有一个正的美丽价值，描述它看起来是多么美丽。
 * 帕特尔医生希望今晚晚餐准确地用 p 盘子。 如果他想在一堆中拿一个盘子，他也必须在那堆中拿上面的所有盘子。
 * 帮助帕特尔博士挑选 p 牌照，最大限度地提高美容价值的总和。
 * Problem
 * Dr. Patel has N stacks of plates. Each stack contains K plates.
 * Each plate has a positive beauty value, describing how beautiful it looks.
 *
 * Dr. Patel would like to take exactly P plates to use for dinner tonight.
 * If he would like to take a plate in a stack, he must also take all of the plates above it in that stack as well.
 *
 * Help Dr. Patel pick the P plates that would maximize the total sum of beauty values.
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 * Each test case begins with a line containing the Three integers N, K and P.
 * Then, N lines follow.
 * The i-th line contains K integers, describing the beauty values of each stack of plates
 * from top to bottom.
 *
 * Output
 * For each test case, output One line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum total sum of beauty values that Dr. Patel could pick.
 *
 * Limits
 * Time limit: 20 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 1 ≤ K ≤ 30.
 * 1 ≤ P ≤ N * K.
 * The beauty values are between 1 and 100, inclusive.
 *
 * Test set 1
 * 1 ≤ N ≤ 3.
 *
 * Test set 2
 * 1 ≤ N ≤ 50.
 *
 * Sample
 *
 * Input
 *
 * Output
 *
 * 2
 * 2 4 5
 * 10 10 100 30
 * 80 50 10 50
 * 3 2 3
 * 80 80
 * 15 50
 * 20 10
 *
 *
 * Case #1: 250
 * Case #2: 180
 *
 *
 * In Sample Case #1, Dr. Patel needs to pick P = 5 plates:
 * He can pick the top 3 plates from the first stack (10 + 10 + 100 = 120).
 * He can pick the top 2 plates from the second stack (80 + 50 = 130) .
 * In total, the sum of beauty values is 250.
 *
 * In Sample Case #2, Dr. Patel needs to pick P = 3 plates:
 * He can pick the top 2 plates from the first stack (80 + 80 = 160).
 * He can pick no plates from the second stack.
 * He can pick the top plate from the third stack (20).
 * In total, the sum of beauty values is 180.
 *
 * Note: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
 */
import java.util.*;
import java.io.*;
/**
 * Created by wcxdhr on 2020-03-22.
 */
public class Plates {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            int p = in.nextInt();
            int[][] value = new int[n][k];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    value[j][l] = l == 0 ? in.nextInt() : value[j][l - 1] + in.nextInt();
                }

            }
            ans = 0;
            for (int j = 0; j < value.length; j++) {
                maxValue(n, k, p, j, 0, value);
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static int ans = 0;

    private static void maxValue(int n, int k, int p, int index, int sum, int[][] value) {
        if (p < 0)
            return;
        else if (p == 0){
            ans = Math.max(ans, sum);
            return;
        }
        if (index == n - 1){
            if (p > k)
                return;
            ans = Math.max(ans, value[n - 1][p - 1] + sum);
            return;
        }
        for (int i = index; i < n; i++) {
            for (int j = 0; j < k; j++) {
                maxValue(n, k , p - j - 1, i + 1, sum + value[i][j], value);
            }
        }
    }
}
