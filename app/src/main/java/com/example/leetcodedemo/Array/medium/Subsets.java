package com.example.leetcodedemo.Array.medium;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/9/12.
 */
public class Subsets {

    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<Integer>());
        List<Integer> sub = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sub.add(nums[i]);
        }
        findAllsubsets(sub);
        HashSet<List<Integer>> set = new HashSet<>();
        set.addAll(ans);
        ans.clear();
        ans.addAll(set);
        return ans;
    }

    private void findAllsubsets(List<Integer> nums) {
        if (nums.size() > 0) {
            ans.add(nums);
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> sub = new ArrayList<>();
                for (int j = 0; j < nums.size() && j != i; j++) {
                    sub.add(nums.get(j));
                    ans.add(sub);
                    findAllsubsets(sub);
                }
            }
        }
    }
}
