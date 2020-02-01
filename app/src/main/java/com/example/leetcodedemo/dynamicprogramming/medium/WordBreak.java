package com.example.leetcodedemo.dynamicprogramming.medium;
/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.List;

/**
 * Created by wcxdhr on 2020/2/1.
 */

public class WordBreak {

    public static void main(String[] args) {
        new WordBreak().wordBreak("applepenapple", Arrays.asList(new String[]{"apple", "pen"}));
    }

    /**
     * 依然是coin change的变体，这一系列问题都是这么处理，再有一些边界问题需要注意
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;
        for (int i = 1; i <= sLen; i++) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    int index = (s.substring(0, i).lastIndexOf(word));
                    if (index != -1 && index + word.length() == i)
                        if ((dp[i] = dp[index]) == true)
                            break;
                }
            }
        }
        return dp[sLen];
    }

}
