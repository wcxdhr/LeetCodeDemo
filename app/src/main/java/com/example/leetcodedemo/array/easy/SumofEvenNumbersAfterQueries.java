package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class SumofEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int num : A) {
            if ((num&1) == 0)
                evenSum += num;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if ((A[queries[i][1]]&1) == 0) {
                evenSum -= A[queries[i][1]];
            }
            if (((A[queries[i][1]] + queries[i][0])&1) == 0){
                evenSum += (A[queries[i][1]] + queries[i][0]);
            }
            A[queries[i][1]] += queries[i][0];
            ans[i] = evenSum;
        }
        return ans;
    }
}
