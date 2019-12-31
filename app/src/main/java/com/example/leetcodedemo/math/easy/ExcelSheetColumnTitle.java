package com.example.leetcodedemo.math.easy;
/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/12/30.
 */
public class ExcelSheetColumnTitle {

    /**
     * 重要思路：当余数为0时，说明字母多一位，此时得到的/26的n需减1.
     * 题解中的思路：转化为进制问题，每26进一位
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int tmp = n % 26;
            n = n / 26;
            if (tmp == 0)
                n--;
            builder.append((char)((tmp == 0 ? 25 : tmp - 1) + 'A'));
        }
        return builder.reverse().toString();
    }
}
