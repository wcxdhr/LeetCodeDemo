package com.example.leetcodedemo.string.easy;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/11.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length == 0)
            return ans;
        int minLen = strs[0].length();
        for (String str : strs)
            minLen = Math.min(str.length(), minLen);
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j -1].charAt(i) != strs[j].charAt(i))
                    return ans;
            }
            ans += strs[0].substring(i, i + 1);
        }
        return ans;
    }
}
