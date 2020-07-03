package com.example.leetcodedemo.array.easy;
/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> countNum = new HashMap<>();
        for (int num : nums) {
            if (countNum.containsKey(num))
                return true;
            else
                countNum.put(num, true);
        }
        return false;
    }
}
