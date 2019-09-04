package com.example.leetcodedemo.Array.medium;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wcxdhr on 2019/8/21.
 */

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-5,-1,-5,-4,2,1,-1,2,-4,-3,-2,-4}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3)
            return ans;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        int j = nums.length  -1;
        if (nums[i] > 0 || nums[j] < 0)
            return ans;
        if (map.containsKey(0)) {
            while (i + 1 < j && nums[i] <= 0 && nums[j] >= 0) {
                if (nums[i] + nums[j] < 0)
                    i++;
                else if (nums[i] + nums[j] > 0)
                    j--;
                else {
                    ans.add(Arrays.asList(new Integer[]{nums[i++], 0, nums[j--]}));
                    while (i + 1 < j && nums[i] == nums[i - 1])
                        i++;
                    while (i + 1 < j && nums[j] == nums[j + 1])
                        j--;
                }
            }
        }
        i = 0;
        j = nums.length - 1;
        while (nums[i] < 0 && nums[j] > 0) {
            if (nums[i] + nums [j] < 0) {
                if (map.containsKey(-(nums[i] + nums [j]))) {
                    if (nums[i] + nums[j] * 2 == 0) {
                        if (map.get(nums[j]) > 1)
                            ans.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[j]}));
                    }
                    else if (map.get(-(nums[i] + nums [j])) > 0)
                        ans.add(Arrays.asList(new Integer[]{nums[i], -(nums[i] + nums [j]), nums[j]}));
                }
            }
            j--;
            while (nums[j] == nums[j + 1])
                j--;
            if (nums[i] + nums[j] * 2 < 0) {
                j = nums.length - 1;
                i++;
                while (nums[i] < 0 && nums[i] == nums[i - 1])
                    i++;
            }

        }
        i = 0;
        j = nums.length - 1;
        while (nums[i] < 0 && nums[j] > 0) {
            if (nums[i] + nums [j] > 0) {
                if (map.containsKey(-(nums[i] + nums [j]))) {
                    if (nums[i] * 2 + nums[j] == 0) {
                        if (map.get(nums[i]) > 1)
                            ans.add(Arrays.asList(new Integer[]{nums[i], nums[i], nums[j]}));
                    }
                    else if (map.get(-(nums[i] + nums [j])) > 0)
                        ans.add(Arrays.asList(new Integer[]{nums[i], -(nums[i] + nums [j]), nums[j]}));
                }
            }
            i++;
            while (nums[i] == nums[i - 1])
                i++;
            if (nums[i] * 2 + nums[j] > 0) {
                j--;
                while (nums[j] > 0 && nums[j] == nums[j + 1])
                    j--;
                i = 0;
            }
        }
        return ans;
    }
}
