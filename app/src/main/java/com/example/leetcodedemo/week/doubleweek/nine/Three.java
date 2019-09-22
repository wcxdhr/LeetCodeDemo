package com.example.leetcodedemo.week.doubleweek.nine;

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/9/21.
 */

public class Three {

    public static void main(String[] args) {
        int[][] digits = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
        Three three = new Three();
        System.out.println(three.smallestCommonElement(digits));

    }

    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (map.containsKey(mat[i][j])) {
                    if (map.get(mat[i][j]) == mat.length - 1)
                        return mat[i][j];
                    else map.put(mat[i][j], map.get(mat[i][j]) + 1);
                }
                else map.put(mat[i][j], 1);
                while (j + 1< mat[i].length && mat[i][j] == mat[i][j + 1])
                    j++;
            }

        }
        return -1;
    }
}
