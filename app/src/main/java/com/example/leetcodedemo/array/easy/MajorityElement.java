package com.example.leetcodedemo.array.easy;
/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/8/22.
 */

public class MajorityElement {

    public static void main(String[] args) {
        int[] digits = {2,2,0,1,1,2};
        System.out.println(majorityElement(digits));
    }

    /**
     * 3.17更新：摩尔投票法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == candidate)
                count++;
            else {
                count--;
                if (count == 0)
                    candidate = nums[i];
            }
        }
        return candidate;
    }

    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i]))
                countMap.put(nums[i], 1);
            else if (countMap.get(nums[i]) == nums.length / 2)
                return nums[i];
            else countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }
        return nums[nums.length - 1];
    }
}
