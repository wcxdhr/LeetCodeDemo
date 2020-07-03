package com.example.leetcodedemo.array.easy;
/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */

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
