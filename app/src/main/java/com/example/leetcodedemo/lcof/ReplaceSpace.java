package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 通过次数44,045提交次数57,364
 */

/**
 * Created by wcxdhr on 2020-06-19.
 */
public class ReplaceSpace {
    /**
     * 这个解法感觉毫无技术含量
     * 可看下offercode包下的官方解答：限制空间只能原地修改，需遍历求得新长度，setLength设置新长度
     * 接着再从后往前移动。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (c == ' ')
                 builder.append("%20");
             else builder.append(c);
        }
        return builder.toString();
    }
}
