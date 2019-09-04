package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class OnebitandTwobitCharacters {

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    /**
     * 从左到右遍历
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1)
                i +=2;
            else
                i++;
        }
        if (i == bits.length - 1)
            return true;
        else
            return false;
    }
}
