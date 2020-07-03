package com.example.leetcodedemo.string.easy;
/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "Allocation 1"  ("一个一") , 即 11。
 * 11 被读作 "Allocation 1s" ("两个一"）, 即 21。
 * 21 被读作 "Allocation 2",  "Allocation 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/10/11.
 */
public class CountandSay {
    public String countAndSay(int n) {
        String prev;
        String ans = "1";
        for (int i = 1; i < n; i++) {
            prev = ans;
            ans = "";
            for (int j = 0; j < prev.length(); j++) {
                int k = j + 1;
                int count = 1;
                 while (k < prev.length()) {
                     if (prev.charAt(j) != prev.charAt(k))
                         break;
                     k++;
                     count++;
                 }
                j = k - 1;
                 ans = ans + (count > 0 ? String.valueOf(count) : "") + prev.substring(j, k);
            }
        }
        return ans;
    }
}
