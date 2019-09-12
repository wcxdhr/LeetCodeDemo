package com.example.leetcodedemo.Array.medium;

import android.drm.DrmStore;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Created by Wcxdhr on 2019/9/11.
 *
 * 优化：List与Array相互转化，使用Comparator来快排，
 * 参考：https://leetcode-cn.com/problems/merge-intervals/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-40/
 */
public class MergeIntervals {



    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[][]{};
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] tmp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = tmp;
                }
            }
        }
        int count = 0;
        int currentRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (currentRight >= intervals[i][0])
                count++;
            currentRight = Math.max(currentRight, intervals[i][1]);
        }
        int[][] ans = new int[intervals.length - count][2];
        ans[0] = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (ans[j][1] >= intervals[i][0])
                ans[j][1] = Math.max(ans[j][1], intervals[i][1]);
            else
                ans[++j] = intervals[i];
        }
        return ans;
    }
}
