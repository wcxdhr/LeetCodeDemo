package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class NondecreasingArray {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                index = i;
            }
            if (count == 2)
                return false;
        }
        if (index != -1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < nums.length - 1; j++) {
                    if (j == nums.length - 2)
                        return true;
                    if (j == index)
                        continue;
                    if (j == index - 1) {
                        if (nums[j] > nums[j + 2])
                            break;
                    }
                    else if (nums[j] > nums[j + 1])
                        break;
                }
                index++;
            }
            return false;
        }
        return true;
    }

}
