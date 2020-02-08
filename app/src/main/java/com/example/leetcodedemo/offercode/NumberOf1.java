package com.example.leetcodedemo.offercode;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

/**
 * Created by wcxdhr on 2020/2/6.
 */

public class NumberOf1 {

    public static void main(String[] args) {
        System.out.println(new NumberOf1().NumberOf1(-2147483648));
    }


    /**
     * 官方解答：
     * 重点：左移一位替换除以2（更快），取余则由（N & 1）取代（更快）
     *
     * 惊喜解法：把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变成0
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        //不右移n,而是右移flag，依次看每一位是不是1
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag <<= 1;
        }
        return count;
    }

    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }
    /**
     * 负数用补码表示，这里要清楚：补码 = 原码的反码 + 1
     * @param n
     * @return
     */
    public int NumberOf11(int n) {
        int ans = 0;
        int lowZero = 0;
        boolean zeroFlag = true;
        boolean negFlag = false;
        if (n < 0) {
            if (n == -2147483648)
                return 1;
            negFlag = true;
            n = -n;
        }
        while (n != 0) {
            int tmp = n % 2;
            if (negFlag && zeroFlag) {
                 if (tmp == 0)
                     lowZero++;
                 else
                     zeroFlag = false;
            }
            ans += tmp;
            n /= 2;
        }
        return negFlag ? (32 - ans - lowZero + 1) : ans;
    }
}
