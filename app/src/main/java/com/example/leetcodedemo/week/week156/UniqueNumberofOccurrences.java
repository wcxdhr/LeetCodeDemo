package com.example.leetcodedemo.week.week156;

import java.util.HashMap;

/**
 * Created by Wcxdhr on 2019/9/29.
 */
public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) 
            map.put(i, map.getOrDefault(i, 0) + 1);
        int[] countArr = new int[arr.length];
        for (Integer value : map.values()) {
            if (countArr[value] == 1)
                return false;
            else countArr[value] = 1;
        }
        return true;
    }
}
