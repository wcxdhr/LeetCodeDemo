package com.example.leetcodedemo.array.easy;
/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */

import java.util.Collections;
import java.util.HashMap;

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
