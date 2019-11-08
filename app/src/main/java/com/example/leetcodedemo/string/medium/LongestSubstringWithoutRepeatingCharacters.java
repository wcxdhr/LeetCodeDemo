package com.example.leetcodedemo.string.medium;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

/**
 * Created by Wcxdhr on 2019/10/10.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 滑动窗口，双指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int rigt = 0;
        int left = 0;
        while (rigt < s.length()) {
            if (map.containsKey(s.charAt(rigt))) {
                left = Math.max(map.get(s.charAt(rigt)) + 1, left);
            }
            map.put(s.charAt(rigt), rigt);
            ans = Math.max(ans, rigt - left + 1);
            if (ans > s.length() - left)
                return ans;
            rigt++;
        }
        return ans;
    }
}
