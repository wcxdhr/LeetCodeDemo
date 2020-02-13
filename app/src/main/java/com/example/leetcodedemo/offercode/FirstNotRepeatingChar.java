package com.example.leetcodedemo.offercode;
/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020-02-13.
 */
public class FirstNotRepeatingChar {
    /**
     * 没啥特别解法，就是用数组模拟哈希表来做，这样空间也是常数。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0)
            return -1;
        int[] chars = new int['z' - 'A' + 1];
        Arrays.fill(chars, -2);
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            if (chars[index] == -2)
                chars[index] = i;
            else if (chars[index] >= 0)
                chars[index] = -1;
        }
        int min = str.length();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 0)
                min = Math.min(min, chars[i]);
        }
        return min;
    }
}
