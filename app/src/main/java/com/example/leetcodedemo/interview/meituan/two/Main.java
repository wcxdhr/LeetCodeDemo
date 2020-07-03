package com.example.leetcodedemo.interview.meituan.two;
/**
 * 给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，
 * 每次操作你可以选择序列中的一个数字，让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。
 *
 * 请问众数最多出现多少次。
 */

/**
 * 输入
 * 输入第一行仅包含两个正整数n和x，表示给出的序列的长度和给定的正整数。(1<=n<=100000,1<=x<=1000)
 *
 * 接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=1000)
 *
 * 输出
 * 输出仅包含一个正整数，表示众数最多出现的次数。
 *
 *
 * 样例输入
 * 5 2
 * 3 1 3 2 5
 * 样例输出
 * 3
 *
 * 提示
 * 同学你好！编程题 《最好一样》 样例解释更新为：例如如果序列中所有数字都不修改时，
 * 众数为3，3出现的次数为2，如果我们把两个3都做如题操作，序列会变为3，3，3，2，7，此时众数为3，
 * 出现次数为3，所以我们选择后者方案，输出众数出现的次数，即3。 其余内容不变。
 */

import com.example.leetcodedemo.offercode.MoreThanHalfNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wcxdhr on 2020-03-12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int major = findMajor(num);
        int tmp = major | x;
        int count = 0;
        if (tmp == major) {

            for (int i = 0; i < n; i++) {
               if (major == num[i] || (num[i] | x) == major)
                    count++;
            }
            System.out.println(count);
        }
        System.out.println(count);
    }



    public static int findMajor(int [] array) {
        int count = 1;
        int member = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                member = array[i];
                count = 1;
                continue;
            }
            if (array[i] == member)
                count++;
            else
                count--;
        }
        count = 0;

        return member;
    }
}
