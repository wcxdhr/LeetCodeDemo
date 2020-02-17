package com.example.leetcodedemo.offercode;
/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

/**
 * Created by wcxdhr on 2020-02-16.
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[]{3,32,321,89,75,88}));
    }

    /**
     * 直接比较字符串（字符串compare按照字典序来排
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if ((str[i] + str[j]).compareTo(str[j] + str[i]) > 0) {
                    String tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                }
            }
        }
        String ans = "";
        for (int i = 0; i < str.length; i++) {
            ans += str[i];
        }
        return ans;
    }

}
