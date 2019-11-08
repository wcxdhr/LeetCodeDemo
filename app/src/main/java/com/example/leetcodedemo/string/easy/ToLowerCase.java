package com.example.leetcodedemo.string.easy;
/**
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/22.
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        int dis = 'A' - 'a';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
             if (c >= 'A' && c <= 'Z')
                 c -= dis;
             builder.append(c);
        }
        return builder.toString();
    }
}
