package com.example.leetcodedemo.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcxdhr on 2019/9/2.
 */

public class PositionsofLargeGroups {

    /**
     *  ans.add(Arrays.asList(new Integer[]{i, j}));动态添加List
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] chars = S.toCharArray();
        int left = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[left]) {
                if ((i == chars.length - 1 || chars[i + 1] != chars[left]) && i - left > 1) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(left);
                    tmp.add(i);
                    ans.add(tmp);
                }
            }
            else
                left = i;
        }
        return ans;
    }
}
