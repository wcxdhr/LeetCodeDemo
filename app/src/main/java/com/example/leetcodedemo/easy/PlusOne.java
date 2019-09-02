package com.example.leetcodedemo.easy;

/**
 * Created by wcxdhr on 2019/8/20.
 */

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        digits = plusOne(digits);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }

    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (digits[0] == 0) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }


}
