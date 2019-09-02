package com.example.leetcodedemo.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,1}, 1));
    }

    /**
     * 更优思路：HashSet/滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
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
