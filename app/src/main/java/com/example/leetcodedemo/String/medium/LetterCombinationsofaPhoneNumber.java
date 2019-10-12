package com.example.leetcodedemo.String.medium;
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/10/12.
 */
public class LetterCombinationsofaPhoneNumber {

    List<String> ans = new ArrayList<>();

    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return ans;
        letterHelper(digits, 0, "");
        return ans;
    }

    private void letterHelper(String s, int index, String sub) {
        int n = s.charAt(index) - 48;
        int start = 'a' + (n - 2) * 3;
        if (n > 7)
            start++;
        int end = (n == 7 || n == 9) ? start + 4 : start + 3;
        while (start < end) {
            sub += String.valueOf((char)start++);
            if (index == s.length() - 1)
                ans.add(sub);
            else {
                letterHelper(s, index + 1, sub);
            }
            sub = sub.substring(0, sub.length() - 1);
        }
    }
}
