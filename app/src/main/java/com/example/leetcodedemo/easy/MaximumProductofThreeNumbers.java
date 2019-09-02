package com.example.leetcodedemo.easy;

/**
 * Created by wcxdhr on 2019/8/28.
 */

public class MaximumProductofThreeNumbers {

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1000,-1000,-1000,0,1,999}));
    }

    public static int maximumProduct(int[] nums) {
        int max1,max2,max3;
        max1 = max2 = max3 = -1001;
        int min1, min2;
        min1 = min2 = 1001;
        for (int num : nums) {
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
            if (num < min1) {
                min2 = min1;
                min1 = num;
            }
            else if (num < min2)
                min2 = num;
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
