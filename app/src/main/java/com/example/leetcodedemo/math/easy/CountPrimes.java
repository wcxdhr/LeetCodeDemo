package com.example.leetcodedemo.math.easy;
/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Wcxdhr on 2020/1/7.
 */
public class CountPrimes {


    public static void main(String[] args) {
        CountPrimes.countPrimes(100);
    }


    /**
     * 思路：改进的暴力解法：对所有小于根号n的数，判断是否能整除素数，可以则不是素数。
     */
    static List<Integer> list = new ArrayList<>();

    public static int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                ans++;
                list.add(i);
            }

        }
        return ans;
    }

    private static boolean isPrime(int n) {
        int t = (int)Math.sqrt(n);
        for (Integer i : list) {
            if (i > t)
                break;
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 题解思路：将所有素数的倍数找出来，剩下的就是素数，优化：两个i*i
     * @param n
     * @return
     */
    int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

}
