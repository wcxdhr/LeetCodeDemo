package com.example.leetcodedemo.String.easy;
/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

/**
 * Created by Wcxdhr on 2019/10/22.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), true);
            else
                map.put(s.charAt(i), false);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.get(s.charAt(i)))
                return i;
        }
        return -1;
    }

}
