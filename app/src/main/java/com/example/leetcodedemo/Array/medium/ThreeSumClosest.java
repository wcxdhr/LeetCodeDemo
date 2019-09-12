package com.example.leetcodedemo.Array.medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * Created by Wcxdhr on 2019/9/12.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4,5,6,78,45,3,45,365,7,54,3,23,3,22,2,24,5,56,6,5}, 7));

    }

    /**
     * 与3sum思路相同
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 3)
            return 0;
        int ans = nums[0] + nums[1] + nums[2];
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                }
                if (sum < target)
                    j++;
                else if (sum > target)
                    k--;
                else
                    return ans;
            }
            i++;
        }
        return ans;
    }
}
