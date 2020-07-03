package com.example.leetcodedemo.interview.baidu;
/**
 * 题目描述：
 * 桌子上放着N枚硬币，将其从1到N编号，初始时有的正面朝上，有的反面朝上。
 * 现在要将所有硬币翻至正面朝上，每次可以选择一个区间[L，R]（1≤L≤R≤N），并执行以下两种操作中的一种：
 *
 * ①将编号为L到R的硬币翻面；
 *
 * ②若编号为L到R的硬币均反面朝上，则将其翻至正面朝上。
 *
 * 其中操作①所需的代价为x，操作②所需的代价为y，那么将所有硬币翻至正面朝上所需的总代价最小是多少？
 * 输入
 * 第一行包含三个整数N、x和y，1≤N≤105，1≤x，y≤10。
 *
 * 第二行包含N个空格隔开的整数t1到tN，0≤ti≤1。若ti=0，
 * 则表示i号硬币初始时反面朝上；若ti=1，则表示i号硬币初始时正面朝上。
 *
 * 输出
 * 输出总代价的最小值。
 *
 *
 * 样例输入
 * 3 1 2
 * 0 1 0
 * 样例输出
 * 2
 *
 * 5 1 2
 * 0 0 1 0 1
 *
 * 提示
 * 第一次选择区间[1，3]并执行操作①，第二次选择区间[2，2]并同样执行操作①。
 */

import java.util.*;
import java.io.*;

/**
 * Created by wcxdhr on 2020-03-29.
 */
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = in.nextInt();
        }
        int i = 0;
        int j = N - 1;
        while (i < j && coins[i] == 1)
            i++;
        while (i < j && coins[j] == 1)
            j--;
        int posCount = 0;
        boolean posFlag = false;
        for (int k = i; k <= j; k++) {
            if (coins[k] == 1)
                posFlag = true;
            else {
                if (posFlag) {
                    posCount++;
                    posFlag = false;
                }
            }
        }
        int ans = 0;
        if (posCount == 0)
            ans = Math.min(x, y);
        else
            ans = x + Math.min(x, y);
        System.out.println(ans);
    }
}