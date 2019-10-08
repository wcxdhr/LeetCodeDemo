package com.example.leetcodedemo.week.week156;
/**
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 *
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 *
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 */

/**
 * Created by Wcxdhr on 2019/9/29.
 */
public class RemoveAllAdjacentDuplicatesinStringII {


    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        RemoveAllAdjacentDuplicatesinStringII removeAllAdjacentDuplicatesinStringII = new RemoveAllAdjacentDuplicatesinStringII();
        removeAllAdjacentDuplicatesinStringII.removeDuplicates(s, 3);
    }

    public String removeDuplicates(String s, int k) {
        boolean[] markedArr = new boolean[s.length()];
        String ans = new String();
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < s.length() - k + 1; i++) {
                if (!markedArr[i]) {
                    int count = 1;
                    int index = 1;
                    while (count < k && i + index < s.length()) {
                        if (!markedArr[i + index]) {
                            if (s.charAt(i) == s.charAt(i + index)) {
                                index++;
                                count++;
                            }
                            else if (s.charAt(i) != s.charAt(i + index))
                                break;
                        }
                        else index++;
                    }
                    if (count == k) {
                        flag = true;
                        while (index >= 1) {
                            markedArr[i + index - 1] = true;
                            index--;
                        }
                    }
                    i += count - 1;
                }
            }
        }
        for (int i = 0; i < markedArr.length; i++) {
            if (!markedArr[i])
                ans += s.substring(i, i + 1);
        }
        return ans;
    }
}
