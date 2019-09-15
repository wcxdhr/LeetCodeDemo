package com.example.leetcodedemo.week.hundred54;
/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 */



/**
 * Created by wcxdhr on 2019/9/15.
 */

public class one {
    public int maxNumberOfBalloons(String text) {
        char[] charArr = text.toCharArray();
        int[] count = new int[5];
        for (char c : charArr) {
            if (c == 'b')
                count[0]+=2;
            else if (c == 'a')
                count[1]+=2;
            else if (c == 'l')
                count[2]++;
            else if (c == 'o')
                count[3]++;
            else if (c == 'n')
                count[4]+=2;
        }
        int ans = count[0];
        for (int i = 1; i < count.length; i++) {
            ans =  Math.min(ans, count[i]);
        }
        return ans / 2;
    }
}
