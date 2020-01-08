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
 * 输入: num1 = "123", num2  = "456"
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

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

/**
 * Created by Wcxdhr on 2020/1/7.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        char[][] tmp = new char[num2.length()][num1.length() + num2.length()];
        for (int i = 0; i < num2.length(); i++)
            Arrays.fill(tmp[i], '0');
        for (int i = num2.length() - 1; i >= 0; i--) {
            int mul = num2.charAt(i) - '0';
            int flag = 0;
            for (int j = num1.length() + i; j >= i + 1; j--) {
                int intJ = num1.charAt(j - i - 1) - '0';
                tmp[i][j] = (char) ((mul * intJ + flag) % 10 + '0');
                flag = (mul * intJ + flag) / 10;
            }
            if (flag != 0)
                tmp[i][i] = (char)(flag + '0');
        }
        StringBuilder builder = new StringBuilder();
        int flag = 0;
        for (int j = num1.length() + num2.length() - 1; j >= 1; j--) {
            int singleSum = flag;
            for (int i = num2.length() - 1; i >= 0; i--) {
                singleSum += (tmp[i][j] - '0');
            }
            flag = singleSum / 10;
            builder.append((char)(singleSum % 10 + '0'));
        }
        if ((tmp[0][0] + flag) != '0')
            builder.append((char)(tmp[0][0] + flag));
        return builder.reverse().toString();
    }
}
