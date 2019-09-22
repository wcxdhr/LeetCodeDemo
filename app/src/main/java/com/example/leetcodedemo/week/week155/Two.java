package com.example.leetcodedemo.week.week155;

/**
 * Created by wcxdhr on 2019/9/22.
 */

public class Two {

    public static void main(String[] args) {
        int[][] digits = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
        Two two = new Two();

        System.out.println(two.nthUglyNumber(1000000000, 2,217983653,336916467));

    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a;
        if (b != min && b != max)
            mid = b;
        else if (c != min && c != max)
            mid = c;
        int ans = min;
        boolean flagmin = true;
        boolean flagmid = true;
        boolean flagmax = true;
        int aCount = mid / min;
        int bCount = 1;
        int cCount = 1;

        return ans;
    }
}
