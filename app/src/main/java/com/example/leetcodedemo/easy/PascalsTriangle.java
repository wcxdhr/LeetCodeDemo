package com.example.leetcodedemo.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/22.
 */

public class PascalsTriangle {

    public static void main(String[] args) {

        System.out.println(generate(0));
    }

    /**
     * 优化：省略额外空间
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0)
            return lists;
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        lists.add(prev);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(prev.get(j) + prev.get(j - 1));
            }
            list.add(1);
            lists.add(list);
            prev = list;
        }
        return lists;
    }
}
