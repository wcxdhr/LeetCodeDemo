package com.example.leetcodedemo.offercode;
/**
 *大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */

/**
 * Created by wcxdhr on 2020/2/5.
 */

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(12));
    }

    public int Fibonacci(int n) {
        if (n < 2)
            return n;
        int f0 = 0, f1 = 1;
        int i = 2;
        int ans = 0;
        while (i <= n) {
            ans = f0 + f1;
            f0 = f1;
            f1 = ans;
            i++;
        }
        return ans;
    }
}

