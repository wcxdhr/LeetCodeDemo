package com.example.leetcodedemo.week.fall;

/**
 * Created by wcxdhr on 2019/9/24.
 */

public class DeepDarkFraction {
    public int[] fraction(int[] cont) {
        if (cont.length == 1)
            return new int[]{cont[0], 1};
        int[] ans = new int[2];
        ans[0] = 1;
        ans[1] = cont[cont.length - 1];
        for (int i = cont.length - 2; i > 0; i--) {
            int tmp = ans[0];
            ans[0] = ans[1];
            ans[1] = tmp + cont[i] * ans[0];
        }
        ans[0] = ans[0] + cont[0] * ans[1];
        if (ans[0] < 0 && ans[1] < 0) {
            ans[0] = -ans[0];
            ans[1] = -ans[1];
        }
        int max = 1;
        int squre = (int)Math.min(Math.sqrt(ans[0]), Math.sqrt(ans[1]));
        for (int i = 2; i < squre; i++) {
            if (ans[0] % i == 0 && ans[i] % i == 0)
                max = i;
        }
        ans[0] /= max;
        ans[1] /= max;
        return ans;
    }
}
