package com.example.leetcodedemo.array.easy;

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
