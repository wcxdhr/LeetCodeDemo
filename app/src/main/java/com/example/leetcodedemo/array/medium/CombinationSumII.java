package com.example.leetcodedemo.array.medium;
/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/9/18.
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] digits = {10,1,2,7,6,1,5};
        CombinationSumII combinationSum = new CombinationSumII();
        System.out.println(combinationSum.combinationSum2(digits, 8));

    }

    /**
     * 优化：如何去重？根据递归的顺序：若i == i - 1 的数，则跳过（在上一层递归中已考虑过）
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            findSum(candidates, target, i, list);
        }
        return ans;
    }

    private void findSum(int[] nums, int target, int index, List<Integer> list) {
        if (target > nums[index]) {
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] + nums[index] > target)
                    break;
                if (i > index + 1 && nums[i] == nums[i - 1])
                    continue;
                list.add(nums[index]);
                findSum(nums, target - nums[index], i, list);
                list.remove(list.size() - 1);
            }
        }
        else if (target == nums[index]) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[index]);
            ans.add(newList);
        }
    }
}
