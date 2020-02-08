package com.example.leetcodedemo.dynamicprogramming.medium;
/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 *
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020/2/2.
 */

public class LongestIncreasingSubsequence {

    /**
     * 此法为o(n2)的动态规划，要达到O(n log n)就如下：
     *
     * 动态规划+二分查找
     * 很具小巧思。新建数组 cell，用于保存最长上升子序列。
     *
     * 对原序列进行遍历，将每位元素二分插入 cell 中。
     *
     * 如果 cell 中元素都比它小，将它插到最后
     * 否则，用它覆盖掉比它大的元素中最小的那个。
     * 总之，思想就是让 cell 中存储比较小的元素。这样，cell 未必是真实的最长上升子序列，但长度是对的。
     *
     * 作者：coldme-2
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-e/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
