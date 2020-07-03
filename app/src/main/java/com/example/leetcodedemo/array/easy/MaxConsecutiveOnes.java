package com.example.leetcodedemo.array.easy;
/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */

/**
 * Created by wcxdhr on 2019/8/28.
 */

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,2,3}));
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1)
                count++;
            else {
                if (count > maxCount)
                    maxCount = count;
                count = 0;
            }
        }
        return Math.max(maxCount,count);
    }
}
