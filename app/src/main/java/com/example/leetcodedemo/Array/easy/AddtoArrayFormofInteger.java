package com.example.leetcodedemo.Array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class AddtoArrayFormofInteger {

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }

    /**
     * 更优解法：将数组每一位与K相加，再进位
     * @param A
     * @param K
     * @return
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        if (A[0] == 0 && K == 0) {
            ans.add(0);
            return ans;
        }
        int[] arrK = new int[5];
        arrK[0] = K / 10000;
        int tmp = K % 10000;
        for (int i = 1; i < 5; i++) {
            arrK[i] = tmp / (int)(Math.pow(10, 4 - i));
            tmp = tmp % (int)(Math.pow(10, 4 - i));
        }
        int i = A.length - 1;
        int j = arrK.length - 1;
        boolean plusOne = false;
        while (i >= 0 && j >= 0) {
            if (A[i] + arrK[j] + (plusOne ? 1 : 0) >= 10) {
                ans.add(0, (A[i--] + arrK[j--] + (plusOne ? 1 : 0)) % 10);
                plusOne = true;
            }
            else {
                ans.add(0, A[i--] + arrK[j--] + (plusOne ? 1 : 0));
                plusOne = false;
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                if (A[i] + (plusOne ? 1 : 0) >= 10) {
                    ans.add(0, (A[i--] + (plusOne ? 1 : 0)) % 10);
                    plusOne = true;
                }
                else {
                    ans.add(0, A[i--] + (plusOne ? 1 : 0));
                    plusOne = false;
                }
            }
        }
        else if (j >= 0) {
            while (j >= 0) {
                if (arrK[j] + (plusOne ? 1 : 0) >= 10) {
                    ans.add(0, (arrK[j--] + (plusOne ? 1 : 0)) % 10);
                    plusOne = true;
                }
                else {
                    ans.add(0, arrK[j--] + (plusOne ? 1 : 0));
                    plusOne = false;
                }
            }
        }
        if (plusOne)
            ans.add(0, 1);
        if (ans.size() > 1) {
            while (ans.get(0) == 0)
                ans.remove(0);
        }
        return ans;
    }
}
