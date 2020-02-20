package com.example.leetcodedemo.offercode;
/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 *     1a33
 * 输出
 * 复制
 * 2147483647
 *     0
 */

/**
 * Created by wcxdhr on 2020-02-20.
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("2147483648"));
    }

    /**
     * 边界处理：负数最小值以及正数最大值
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        int ans = 0;
        if (str.length() == 0)
            return ans;
        boolean negFlag = false;
        int i = 0;
        char c = str.charAt(i);
        if ( c == '-' || c == '+') {
            negFlag = c == '-' ? true : false;
            i++;
        }
        int mul = (int) Math.pow(10, str.length() - i - 1);
        for (; i < str.length(); i++) {
            c = str.charAt(i);
            if (c > '9' || c < '0')
                return 0;
            int tempAns = negFlag ? ans - ((c- '0') * mul) : ans + ((c- '0') * mul);
            if (negFlag && ans < tempAns || !negFlag && ans > tempAns)
                return 0;
            ans = tempAns;
            mul /=10;
        }
        return ans;
    }
}
