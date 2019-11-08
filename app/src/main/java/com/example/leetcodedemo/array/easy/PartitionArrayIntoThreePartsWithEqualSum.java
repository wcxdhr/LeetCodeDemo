package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A)
            sum += num;
        if (sum % 3 != 0)
            return false;
        sum /= 3;
        int curSum = 0;
        int count = 0;
        for (int num : A) {
            curSum += num;
            if (curSum == sum) {
                curSum = 0;
                count++;
            }
        }
        return count == 3;
    }
}
