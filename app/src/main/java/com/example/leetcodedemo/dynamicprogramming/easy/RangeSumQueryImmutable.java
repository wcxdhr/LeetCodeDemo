package com.example.leetcodedemo.dynamicprogramming.easy;
/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;

/**
 * Created by wcxdhr on 2020/1/19.
 */

public class RangeSumQueryImmutable {

    public static void main(String[] args){
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,2);
    }

    /**
     * 本题较简单，注意indexof是找元素的下标啊，get才是从下标找元素。
     */
    static class NumArray {

        ArrayList<Integer> sum = new ArrayList<>();

        public NumArray(int[] nums) {
            if (nums.length == 0)
                return;
            sum.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                sum.add(sum.get(i - 1) + nums[i]);
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return sum.get(j);
            else
                return sum.get(j) - sum.get(i - 1);
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

}
