package com.example.leetcodedemo.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class DegreeofanArray {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }

    /**
     * HashMap 空间换时间：记录左右索引值
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>(),
        right = new HashMap<>(), count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int max = Collections.max(count.values());
        int ans = nums.length;
        for (int key : count.keySet()) {
            if (count.get(key) == max)
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
        }
        return ans;
    }
}
