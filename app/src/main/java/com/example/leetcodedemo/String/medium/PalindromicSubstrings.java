package com.example.leetcodedemo.String.medium;
/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/24.
 */
public class PalindromicSubstrings {

    /**
     * 更优解法：中心扩展法
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            ans += checkSubStrings(s, i, i);
            ans += checkSubStrings(s, i ,i + 1);
        }
        return ans;
    }

    private int checkSubStrings(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++))
            count++;
        return count;
    }
}
