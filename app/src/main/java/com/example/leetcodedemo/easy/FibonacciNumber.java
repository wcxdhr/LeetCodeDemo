package com.example.leetcodedemo.easy;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    /**
     * 使用动态规划/数组
     * @param N
     * @return
     */
    public static int fib(int N) {
        int[] fibArr = new int[31];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
        return fibArr[N];
    }
}
