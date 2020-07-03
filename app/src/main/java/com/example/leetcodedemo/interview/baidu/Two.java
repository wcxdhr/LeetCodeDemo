package com.example.leetcodedemo.interview.baidu;
/**
 * 题目描述：
 * 首先给出n个数字a1,a2,….an，然后给你m个回合，每回合你可以从中选择一个数取走它，
 * 剩下来的每个数字ai都要减去一个值bi。如此重复m个回合，所有你拿走的数字之和就是你所得到的分数。
 *
 * 现在给定你a序列和b序列，请你求出最多可以得到多少分。
 *
 * 输入
 * 输入第一行，仅包含一个整数n（1<=n<=100），表示数字的个数。
 *
 * 第二行，一个整数m（1<=m<=n），表示回合数。
 *
 * 接下来一行有n个不超过10000的正整数，分别为a1,a2…an.
 *
 * 最后一行有n个不超过500的正整数，分别为b1,b2….bn.
 *
 * 输出
 * 输出仅包含一个正整数，即最多可以得到的分数
 *
 *
 * 样例输入
 * 5
 * 5
 * 10 20 30 40 50
 * 4 5 6 7 8
 * 样例输出
 * 100
 *50 + 33 + 18 + 5 - 6 = 100
 */
import java.util.*;
import java.io.*;
/**
 * Created by wcxdhr on 2020-03-29.
 */
public class Two {


    public static class Score {
        int a;
        int b;
        boolean used = false;
        public Score(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int m = in.nextInt();
        Score[] scores = new Score[n];
        for (int i = 0; i < n; i++) {
            scores[i] = new Score(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            scores[i].b = in.nextInt();
        }
        Arrays.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.a - o1.a == 0 ? o1.b - o2.b : o2.a - o1.a;
            }
        });
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int max = -1;
            int maxIndex = -1;
            for (int j = 0; j < m; j++) {
                if (!scores[j].used && scores[j].b > max) {
                    max = scores[j].b;
                    maxIndex = j;
                }
            }
            ans += (scores[maxIndex].a - max * i);
            scores[maxIndex].used = true;
        }
        System.out.println(ans);
    }
}
