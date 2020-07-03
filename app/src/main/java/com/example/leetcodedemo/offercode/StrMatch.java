package com.example.leetcodedemo.offercode;
/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"Allocation.Allocation"和"ab*ac*Allocation"匹配，但是与"aa.Allocation"和"ab*Allocation"均不匹配
 */

import android.animation.ValueAnimator;
import android.graphics.BitmapFactory;
import android.util.LruCache;

/**
 * Created by wcxdhr on 2020-02-25.
 */
public class StrMatch {
    /**
     *这个题我刚开始看不懂，注意，这个*前面的字符只是指*前面相邻的最后一个字符
     * leetcode上有相似题，可以参考下题解
     * https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
        LruCache<Integer, String> lruCache = new LruCache<>(5);
        ValueAnimator animator = new ValueAnimator();
        animator.setRepeatCount(-1);
        return matchHelper(str, 0,pattern, 0);
    }

    /**
     * 分下一个字符是不是*来讨论
     * @param str
     * @param i
     * @param pattern
     * @param j
     * @return
     */
    private boolean matchHelper(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j == pattern.length)
            return true;
        else if (j == pattern.length)
            return false;
        if ((j + 1) < pattern.length && pattern[j + 1] == '*') {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                return matchHelper(str, i, pattern, j + 2) || matchHelper(str, i + 1, pattern, j );
            else
                return matchHelper(str, i, pattern, j + 2);
        }
        else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                return matchHelper(str, i + 1, pattern, j + 1);
            else
                return false;
        }
    }
}
