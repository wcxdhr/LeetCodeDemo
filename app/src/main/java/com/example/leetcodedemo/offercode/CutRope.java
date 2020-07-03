package com.example.leetcodedemo.offercode;
/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 输出
 * 18
 *
 */

import android.os.SystemPropertiesProto;

/**
 * Created by wcxdhr on 2020-02-29.
 */
public class CutRope {

    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(4));
    }


    /**
     * 官方解答把0-3都当做特例，之后的dp[i] = Math.max(dp[j] * dp[i - j], dp[i]),j <= i / 2;
     * 速度更快些；
     * @param target
     * @return
     */
    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=target; i++) {
            dp[i] = 0;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[j] * (i - j), dp[i]);
                dp[i] = Math.max( j * (i - j), dp[i]);
            }
        }
        return dp[target];
    }
}
