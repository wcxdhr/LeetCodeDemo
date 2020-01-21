package com.example.leetcodedemo.string.medium;
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/11.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("yxyslls");
    }

    /**
     * 思路：参考中心扩展法，从字符串中间往两边扩展，找最大的回文，感觉判断条件很复杂，代码也很乱。
     * 题解优化：马车算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ans = "";
        int medium = s.length() / 2;
        int i = 0;
        while (medium >= i) {
            if (ans.length() > (medium - i + 1) * 2)
                break;
            int len = isPalindromicHelper(medium + i, medium + i, s);
            if (len > ans.length())
                ans = s.substring(medium + i - len / 2, medium + i + len / 2 + 1);
            len = isPalindromicHelper(medium + i, medium + i + 1, s);
            if (len > ans.length())
                ans = s.substring(medium + i - len / 2 + 1, medium + i + len / 2 + 1);
            len = isPalindromicHelper(medium - i, medium - i, s);
            if (len > ans.length())
                ans = s.substring(medium - i - len / 2, medium - i + len / 2 + 1);
            len = isPalindromicHelper(medium - i, medium - i + 1, s);
            if (len > ans.length())
                ans = s.substring(medium - i - len / 2 + 1, medium - i + len / 2 + 1);
            i++;
        }
        return ans;
    }

    private int isPalindromicHelper(int start, int end, String s) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end))
                break;
            start--;
            end++;
        }
        return end - start - 1;
    }


    /**
     * 题解：动态规划，二维动态规划，思考：回文的判断，怎样可以得到这一段是回文呢？
     * 取决于当前的ij是否相等，及i和j之间是否是回文
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     * @param s
     * @return
     */
    public String longestPalindrome1(String s){
        if (s.length() < 2)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        int maxLen = 1;
        int start = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i >= 3)
                        dp[i][j] = dp[i + 1][j - 1];
                    else
                        dp[i][j] = true;
                }
                else
                    dp[i][j] = false;
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen + 1);
    }
}
