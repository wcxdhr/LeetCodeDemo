package com.example.leetcodedemo.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,1}));
    }

    public static int thirdMax(int[] nums) {
        int max1,max2,max3;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
            if (num == max1 || num == max2 || num == max3)
                continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (num > max3)
                max3 = num;
        }
        return hs.size() < 3 ? max1 : max3;
    }
}
