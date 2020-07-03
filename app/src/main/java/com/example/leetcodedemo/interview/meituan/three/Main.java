package com.example.leetcodedemo.interview.meituan.three;
/**
 * 小美曾经有一个特殊的数组，这个数组的长度为n。但是她在打恐怖游戏的时候被吓得忘记了这个数组长什么样了。
 * 不过她还记得这个数组满足一些条件。
 *
 * 首先这个数组的每个数的范围都在L和R之间。包括端点。
 *
 * 除此之外，这个数组满足数组中的所有元素的和是k的倍数。
 *
 * 但是这样的数组太多了，小美想知道有多少个这样的数组。你只需要告诉她在模1e9+7意义下的答案就行了。
 */
/**
 * 输入
 * 一行四个整数n,k,L,R
 *
 * （1≤n≤1e5    1≤k≤10    1≤L≤R≤1e9）
 *
 * 输出
 * 输出一个数表示满足条件的数组的个数。
 *
 *
 * 样例输入
 * 9 1 1 3
 * 样例输出
 * 19683
 */

import android.os.SystemPropertiesProto;

import java.util.Scanner;

/**
 * Created by wcxdhr on 2020-03-12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int k = x.nextInt();
        int l = x.nextInt();
        int r = x.nextInt();
        int mod = 1000000007;
        int num = (r / k - l / k);
        if (r % k == 0 && l % k == 0) num++;
        int ans = 1;
        while (n > 0) {
            ans = (ans * num) % mod;
            n--;
        }
        System.out.println(ans);
    }


}
