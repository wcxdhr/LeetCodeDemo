package com.example.leetcodedemo.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for (int i = 2; i <= rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(prev.get(j) + prev.get(j - 1));
            }
            list.add(1);
            prev = list;
        }
        return prev;
    }
}
