package com.example.leetcodedemo.array.medium;
/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

/**
 * Created by Wcxdhr on 2019/9/27.
 */
public class SubarraySumEqualsK {

    /**
     * 累计和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            countMap.put(curSum, countMap.getOrDefault(curSum, 0) + 1);
        }
        curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            count += countMap.getOrDefault(k - curSum, 0);
            curSum += nums[i];
            countMap.put(curSum, countMap.get(curSum) - 1);
        }
        return count;
    }
}
