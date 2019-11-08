package com.example.leetcodedemo.array.medium;
/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/9/17.
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] digits = {2,3,6,7};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(digits, 7));

    }

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 回溯+剪枝，主流解法：减法（画生成树）
     * 优化：剪枝,根据target是否大于0判断，去掉k值的使用
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int count = 0;
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            if (candidate > target )
                break;
            count++;
        }
        List<Integer> list = new ArrayList<>();
        findSum(candidates, target,0, count, list);
        return ans;
    }

    private void findSum(int[] nums, int target, int index, int count, List<Integer> list) {
        for (int i = index; i < count; i++) {
            if (target > nums[i]) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(nums[i]);
                findSum(nums, target - nums[i],  i, count, newList);
            }
            else if (target == nums[i]) {
                list.add(nums[i]);
                ans.add(list);
            }
        }
    }
}
