package com.example.leetcodedemo.array.easy;
/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，
 * 如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */

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
     * (2020.3.17:我为啥要写这么复杂
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
