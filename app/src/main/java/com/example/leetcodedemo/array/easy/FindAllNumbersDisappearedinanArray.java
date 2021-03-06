package com.example.leetcodedemo.array.easy;
/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ Allocation[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，
 * 另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/28.
 */

public class FindAllNumbersDisappearedinanArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{0,0,2,3}));
    }

    /**
     * 更优解法：数组下标与数组元素的对应关系
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disNum = new ArrayList<>();
        int[] hs = new int[nums.length];
        for (int num : nums) {
            hs[num] = 1;
        }
        for (int i = 0; i < hs.length; i++) {
            if (hs[i] == 0)
                disNum.add(i);
        }
        return disNum;
    }
}
