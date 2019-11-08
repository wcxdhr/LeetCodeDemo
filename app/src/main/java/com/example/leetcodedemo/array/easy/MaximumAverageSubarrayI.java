package com.example.leetcodedemo.array.easy;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double ans = -10000;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i != 0) {
                sum = sum - nums[i - 1] + nums[i + k - 1];
            }
            double average = sum*1.0 / k;
            if (average > ans)
                ans = average;
        }
        return ans;
    }
}
