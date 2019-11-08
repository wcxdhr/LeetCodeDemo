package com.example.leetcodedemo.array.medium;
/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wcxdhr on 2019/9/16.
 */
public class FourSum {

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 优化：剪枝
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length - 3; i++) {
            /**
             * 极端情况剪枝：速度可提升3倍
             */
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[3] > target)
                break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue;
            findThreeSum(nums, i + 1, target - nums[i] );
            while (i < nums.length - 3 && nums[i] == nums[i + 1])
                i++;
        }
        return ans;
    }

    private void findThreeSum(int[] nums, int index, int target) {
        for (int i = index; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                boolean flagJ = false, flagK = false;
                if (nums[i] + nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index - 1]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    flagJ = true;
                    flagK = true;

                }
                else if (nums[i] + nums[j] + nums[k] < target)
                    flagJ = true;
                else
                    flagK = true;
                if (flagJ) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                }
                if (flagK) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }

    }
}
