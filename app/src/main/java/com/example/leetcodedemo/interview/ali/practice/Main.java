package com.example.leetcodedemo.interview.ali.practice;
/**
 * 题目描述
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，
 * 我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 * 输入描述:
 * 输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
 * 输出描述:
 * 从小到大输出这段连续非负整数，以空格分隔，行末无空格。
 * 如果没有这样的序列或者找出的序列长度大于100，则输出No
 * 示例1
 * 输入
 * 复制
 * 18 2
 * 输出
 * 复制
 * 5 6 7
 */

import java.util.Scanner;

/**
 * Created by wcxdhr on 2020-03-21.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int count = 0;
        for (int i = 0; i <l; i++) {
            count += i;
        }
        while (l <= 100 && (count <= n)){
            count += l;
            if (n % l == 0) {
                if ((l & 1) == 1) {
                    int start = n / l - (l >> 1);
                    for (int i = start; i < start + l - 1; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.print(start + l - 1);
                    return;
                }
                else
                    l++;
            }
            else if ((n % l) << 1 == l) {
                int start = n / l - (l >> 1) + 1;
                for (int i = start; i < start + l - 1; i++) {
                    System.out.print(i + " ");
                }
                System.out.print(start + l - 1);
                return;
            }
            else l++;
        }
        System.out.println("No");
    }
}
