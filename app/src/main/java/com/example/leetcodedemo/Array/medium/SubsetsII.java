package com.example.leetcodedemo.Array.medium;
/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/9/19.
 */
public class SubsetsII {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0)
            return ans;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        ans.add(list);
        findSubsets(nums, 0, list);
        return ans;
    }

    private void findSubsets(int[] nums, int index, List<Integer> list) {
        if (index < nums.length) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[index]);
            ans.add(newList);
            findSubsets(nums, index + 1, newList);
            int next = index + 1;
            while (next < nums.length) {
                if (nums[next] != nums[index])
                    break;
                next++;
            }
            findSubsets(nums, next, list);
        }
    }
}
