package com.example.leetcodedemo.String.medium;
/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/10/23.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    /**
     * 更优解法：不使用排序，而是使用26长度的数组来表示。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            String sortS = sort(str);
            if (map.containsKey(sortS))
                ans.get(map.get(sortS)).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
                map.put(sortS, ans.size() - 1);
            }
        }
        return ans;
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
