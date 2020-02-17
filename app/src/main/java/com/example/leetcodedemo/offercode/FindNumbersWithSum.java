package com.example.leetcodedemo.offercode;
/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */

import java.util.ArrayList;

/**
 * Created by wcxdhr on 2020-02-16.
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        System.out.println(new FindNumbersWithSum().FindNumbersWithSum(new int[]{1,5,6, 8,9}, 13));
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i <= j) {
            int curSum = array[i] + array[j];
            if ( curSum == sum) {
                ans.add(array[i]);
                ans.add(array[j]);
                break;
            }
            else if (curSum < sum)
                i++;
            else
                j--;
        }
        return ans;
    }
}
