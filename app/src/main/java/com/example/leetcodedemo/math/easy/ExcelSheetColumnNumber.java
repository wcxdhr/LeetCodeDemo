package com.example.leetcodedemo.math.easy;
/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/12/31.
 */
public class ExcelSheetColumnNumber {

    /**
     * 我的思路：从高位到低位逐步计算。缺点：重复计算 1ms 35.7m
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += (Math.pow(26, len - i - 1) * (s.charAt(i) - 'A' + 1));
        }
        return ans;
    }

    /**
     * 部分题解思路，累乘,每发现多一位则*26 1ms 36m
     * 然而没看出来性能差距在哪里2333
     */
    public int titleToNumber2(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = (26 * ans + (s.charAt(i) - 'A' + 1));
        }
        return ans;
    }
}
