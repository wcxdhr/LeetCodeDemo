package com.example.leetcodedemo.math.medium;
/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/pr
 * oblems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2020/1/7.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        char[][] tmp = new char[num2.length()][num1.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int mul = num2.charAt(i) - '0';
            int flag = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int intJ = num2.charAt(j) - '0';
                tmp[i][j] = (char) ((mul +intJ +flag) / 10 + '0');
                flag = (mul +intJ +flag) % 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        return "0";
    }
}
