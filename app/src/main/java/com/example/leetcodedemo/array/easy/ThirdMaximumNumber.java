package com.example.leetcodedemo.array.easy;
/**
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,1}));
    }

    public static int thirdMax(int[] nums) {
        int max1,max2,max3;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
            if (num == max1 || num == max2 || num == max3)
                continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (num > max3)
                max3 = num;
        }
        return hs.size() < 3 ? max1 : max3;
    }
}
