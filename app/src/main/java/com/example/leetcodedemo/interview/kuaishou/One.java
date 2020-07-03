package com.example.leetcodedemo.interview.kuaishou;
import java.util.*;
import java.io.*;
/**
 * Created by wcxdhr on 2020-03-22.
 */
public class One {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(DistanceToHigher(new int[]{175, 179, 174, 163, 176, 177})));
    }

    public static int[] DistanceToHigher (int[] height) {
        int len = height.length;
        int[] ans = new int[len];
        for (int i = 1; i < ans.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (height[i] < height[j]) {
                    ans[i] = i - j;
                    break;
                }
            }
        }
        return ans;
    }
}
