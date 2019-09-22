package com.example.leetcodedemo.week.doubleweek.nine;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/9/21.
 */

public class Four {
    public int minBuildTime(int[] blocks, int split) {
        Arrays.sort(blocks);
        return minTime(blocks, split, blocks.length - 1);
    }

    private int minTime(int[] blocks, int split, int index) {
        if (index > 0)
            return split + Math.max(blocks[index], minTime(blocks, split, index - 1));
        else
            return blocks[0];
    }
}
