package com.example.leetcodedemo.offercode;
/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by wcxdhr on 2020-02-14.
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(new Permutation().Permutation(new String("abc")));
    }

    private ArrayList<String> ans = new ArrayList<>();

    /**
     * 这个重复的不要计算
     * 思路：递归，第一个字母分别和后面每个字母交换
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ans;
        permutationHelper(str.toCharArray(), 0);
        //还要用Collections.sort进行排序
        Collections.sort(ans);
        return ans;
    }

    private void permutationHelper(char[] str, int index) {
        if (index == str.length - 1)
            ans.add(String.valueOf(str));
        else {
            permutationHelper(str, index + 1);
            for (int i = index + 1; i < str.length; i++) {
                if (str[i] != str[index]){
                    swap(str, index, i);
                    permutationHelper(str, index + 1);
                    swap(str, index, i);
                }
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] =str[j];
        str[j] = tmp;
    }
}
