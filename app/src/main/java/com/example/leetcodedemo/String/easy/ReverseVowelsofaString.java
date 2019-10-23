package com.example.leetcodedemo.String.easy;
/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashSet;

/**
 * Created by Wcxdhr on 2019/10/23.
 */
public class ReverseVowelsofaString {

    public static void main(String[] args) {
        new ReverseVowelsofaString().reverseVowels("hEllo");
    }

    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('o');
        set.add('i');
        set.add('u');
        int dis = 'A' - 'a';
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
           while (i < j && !set.contains(chars[i]) && !set.contains((char)(chars[i] - dis)))
               i++;
           while (i < j && !set.contains(chars[j]) && !set.contains((char)(chars[j] - dis)))
               j--;
           if (i < j) {
               char t = chars[i];
               chars[i++] = chars[j];
               chars[j--] = t;
           }
        }
        return String.valueOf(chars);
    }
}
