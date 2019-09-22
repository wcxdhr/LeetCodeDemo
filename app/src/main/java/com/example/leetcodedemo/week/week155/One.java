package com.example.leetcodedemo.week.week155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wcxdhr on 2019/9/22.
 */

public class One {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            minDis = Math.min(minDis, arr[i + 1] - arr[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] == minDis) {
                ans.add(Arrays.asList(new Integer[]{arr[i], arr[i + 1]}));
            }
        }
        return ans;
    }
}
