package com.example.leetcodedemo.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        int curNum = nums[0] - 1;
        while (i < nums.length - 1){
            if (curNum == nums[i]) {
                i++;
                continue;
            }
            int j = i + 1;
            while ( j < nums.length) {
                if (nums[j] - nums[i] == k) {
                    ans++;
                    break;
                }
                else if (nums[j] - nums[i] > k)
                    break;
                j++;
            }
            curNum = nums[i++];
        }
        return ans;
    }
}
