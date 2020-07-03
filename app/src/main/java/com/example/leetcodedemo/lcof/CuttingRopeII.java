package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 通过次数14,235提交次数46,944
 */

/**
 * Created by wcxdhr on 2020-06-26.
 */
public class CuttingRopeII {

    public static void main(String[] args) {
        System.out.println(new CuttingRopeII().cuttingRope(100));
    }


    /**
     * 此题用dp涉及到取余问题，不能比较大小，请看题解的数学推论
     *切分规则：
     * 最优： 33 。把绳子尽可能切为多个长度为 33 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
     * 次优： 22 。若最后一段绳子长度为 22 ；则保留，不再拆为 1+11+1 。
     * 最差： 11 。若最后一段绳子长度为 11 ；则应把一份 3 + 13+1 替换为 2 + 22+2，因为 2 \times 2 > 3 \times 12×2>3×1
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
     * @param n
     * @return
     */
    public int cuttingRope(int n){
        if (n <= 3) return n - 1;
        int mod = 1000000007;
        int rem = n % 3;
        int count = n / 3;
        long ans = 1;
        while (count > 1) {
            ans = (ans * 3) % mod;
            count--;
        }
        //注意这里的if判断
        if (rem == 1) ans = (ans * 4) % mod;
        else if (rem == 2) ans = (ans * 6) % mod;
        else ans = (ans * 3) % mod;
        return (int) ans;
    }

    /**
     * 这种方法不行
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])%1000000007 * Math.max(i - j, dp[i - j])%1000000007)%1000000007);
            }
        }
        return dp[n];
    }
}
