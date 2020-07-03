package com.example.leetcodedemo.interview.kickstart.rounda;
/**
 * 铃鼓已经准备了一个健身计划，这样她可以变得更健康！ 这个程序由 n 个会话组成。
 * 在第届会议期间，铃鼓将运动米分钟。 她每次运动的分钟数都在严格增加。
 * 她的健身计划的难度等于任何两个连续训练课程之间分钟数的最大差距。
 * 为了使她的项目不那么困难，铃鼓决定在她的健身计划中增加多达 k 的额外训练课程。
 * 她可以在她的健身计划中的任何地方增加这些时段，并且在每个时段中锻炼任意正整数分钟。
 * 在增加了额外的训练课程之后，她每次训练的分钟数仍然必须严格增加。 最小的难度是多少？
 * Problem
 * Tambourine has prepared a fitness program so that she can become more fit!
 * The program is made of N sessions. During the i-th session,
 * Tambourine will exercise for Mi minutes.
 * The number of minutes she exercises in each session are strictly increasing.
 *
 * The difficulty of her fitness program is equal to the maximum difference
 * in the number of minutes between any Two consecutive training sessions.
 *
 * To make her program less difficult, Tambourine has decided to add up to K
 * additional training sessions to her fitness program. She can add these sessions anywhere
 * in her fitness program, and exercise any positive integer number of minutes in each of them.
 * After the additional training session are added, the number of minutes she exercises in
 * each session must still be strictly increasing. What is the minimum difficulty possible?
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 * Each test case begins with a line containing the Two integers N and K.
 * The second line contains N integers, the i-th of these is Mi, the number of minutes
 * she will exercise in the i-th session.
 *
 * Output
 * For each test case, output One line containing Case #x: y,
 * where x is the test case number (starting from 1) and
 * y is the minimum difficulty possible after up to K additional training sessions are added.
 *
 * Limits
 * Time limit: 20 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * For at most 10 test cases, 2 ≤ N ≤ 105.
 * For all other test cases, 2 ≤ N ≤ 300.
 * 1 ≤ Mi ≤ 109.
 * Mi < Mi+1 for all i.
 *
 * Test set 1
 * K = 1.
 *
 * Test set 2
 * 1 ≤ K ≤ 105.
 *
 * Samples
 *
 * Input 1
 *
 * Output 1
 *
 * 1
 * 3 1
 * 100 200 230
 *
 * Case #1: 50
 *
 *
 * Input 2
 *
 * Output 2
 *
 * 3
 * 5 2
 * 10 13 15 16 17
 * 5 6
 * 9 10 20 26 30
 * 8 3
 * 1 2 3 4 5 6 7 10
 *
 * Case #1: 2
 * Case #2: 3
 * Case #3: 1
 *
 * Sample #1
 * In Case #1: Tambourine can add up to One session. The added sessions are marked in bold: 100 150 200 230. The difficulty is now 50.
 *
 * Sample #2
 * In Case #1: Tambourine can add up to six sessions. The added sessions are marked in bold: 9 10 12 14 16 18 20 23 26 29 30. The difficulty is now 3.
 *
 * In Case #2: Tambourine can add up to Three sessions. The added sessions are marked in bold: 1 2 3 4 5 6 7 8 9 10. The difficulty is now 1. Note that Tambourine only added Two sessions.
 *
 * Note #1: Only Sample #1 is a valid input for Test set 1. Consequently, Sample #1 will be used as a sample test set for your submissions.
 * Note #2: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
 */

import java.util.*;
import java.io.*;

/**
 * Created by wcxdhr on 2020-03-22.
 */
public class Workout {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] sessions = new int[n];
            for (int j = 0; j < n; j++) {
                sessions[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + minimumDifficulty(n, k, sessions));
        }
    }

    private static int minimumDifficulty(int n, int k, int[] sessions) {
        int[] diffs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = sessions[i + 1] - sessions[i] - 1;
        }
        int[] count = new int[n - 1];
        int maxIndex;
        int secondIndex;
        int max = diffs[0];
        maxIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (diffs[i] > max) {
                max = diffs[i];
                maxIndex = i;
            }
        }
        while (k > 0) {
            secondIndex = secondMax(diffs, diffs[maxIndex]);
            if (secondIndex == -1) secondIndex = maxIndex;
            if (diffs[maxIndex] == 0)
                break;
            int t = diffs[maxIndex] / (diffs[secondIndex] == 0 ? 1 : diffs[secondIndex]) + 1;
            if (t > k + 1)
                t = k + 1;
            diffs[maxIndex] = diffs[maxIndex] / t;
            k -= (t - 1)*(count[maxIndex] + 1);
            count[maxIndex]++;
            maxIndex = secondIndex;
        }
        max = diffs[0];
        for (int i = 1; i < n - 1; i++) {
            if (diffs[i] > max) {
                max = diffs[i];
            }
        }
        return max + 1;
    }

    private static int secondMax(int[] nums, int max) {
        int ans = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max) {
                if (nums[i] > ans) {
                    index = i;
                    ans = nums[i];
                }
            }
        }
        return index;
    }
}
