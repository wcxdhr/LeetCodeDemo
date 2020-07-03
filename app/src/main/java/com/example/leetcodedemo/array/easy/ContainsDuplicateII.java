package com.example.leetcodedemo.array.easy;
/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,1}, 1));
    }

    /**
     * 官方解答
     * 相当于用散列表来维护一个滑动窗口，大小为k
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    /**
     * 更优思路：HashSet/滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> indexNums = new HashMap<>();
        int currentDis = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (indexNums.containsKey(nums[i])) {
                if (currentDis > i - indexNums.get(nums[i]))
                    currentDis = i - indexNums.get(nums[i]);
                if (currentDis <= k)
                    return true;
            }
            indexNums.put(nums[i], i);
        }
        return false;
    }
}
