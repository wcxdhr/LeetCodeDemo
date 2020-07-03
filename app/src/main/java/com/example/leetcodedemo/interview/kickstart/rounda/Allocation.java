package com.example.leetcodedemo.interview.kickstart.rounda;
/**
 * 问题有 n 套房子出售。 买第一栋房子花了i美元。 你有一个 b 美元的预算可以花。
 * 你最多能买多少套房子？ 输入的第一行给出了测试用例的数量，接下来是 t t 测试用例。
 * 每个测试用例都以包含两个整数 n 和 b 的单行开始。 第二行包含 n 个整数。
 * 第一个整数是i，第一个房子的成本。 输出对于每个测试用例，输出一行包含 Case # x: y 的内容，
 * 其中 x 是测试用例编号(从1开始) ，y 是您可以购买的房子的最大数量。
 * Problem
 * There are N houses for sale. The i-th house costs Ai dollars to buy.
 * You have a budget of B dollars to spend.
 *
 * What is the maximum number of houses you can buy?
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 * Each test case begins with a single line containing the Two integers N and B.
 * The second line contains N integers. The i-th integer is Ai, the cost of the i-th house.
 *
 * Output
 * For each test case, output One line containing Case #x: y,
 * where x is the test case number (starting from 1) and y is the maximum number of houses you can buy.
 *
 * Limits
 * Time limit: 15 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 1 ≤ B ≤ 105.
 * 1 ≤ Ai ≤ 1000, for all i.
 *
 * Test set 1
 * 1 ≤ N ≤ 100.
 *
 * Test set 2
 * 1 ≤ N ≤ 105.
 *
 * Sample
 *
 * Input
 *
 * Output
 *
 * 3
 * 4 100
 * 20 90 40 90
 * 4 50
 * 30 30 10 10
 * 3 300
 * 999 999 999
 *
 *
 * Case #1: 2
 * Case #2: 3
 * Case #3: 0
 *
 *
 * In Sample Case #1, you have a budget of 100 dollars. You can buy the 1st and 3rd houses for 20 + 40 = 60 dollars.
 * In Sample Case #2, you have a budget of 50 dollars. You can buy the 1st, 3rd and 4th houses for 30 + 10 + 10 = 50 dollars.
 * In Sample Case #3, you have a budget of 300 dollars. You cannot buy any houses (so the answer is 0).
 * Note: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
 */

import java.util.*;
import java.io.*;
/**
 * Created by wcxdhr on 2020-03-22.
 */
public class Allocation {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int b = in.nextInt();
            int[] houses = new int[n];
            for (int j = 0; j < houses.length; j++) {
                houses[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + maxNumber(houses, n, b));
        }
    }

    private static int maxNumber(int[] houses, int n, int b) {
        Arrays.sort(houses);
        int i = 0;
        int count = 0;
        for (; i < houses.length; i++) {
            count += houses[i];
            if (count > b)
                break;
        }
        return i;
    }

}
