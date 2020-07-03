package com.example.leetcodedemo.interview.kuaishou;
/**
 * 输入用例：
 * 15112347234,15166137234,15188847234,15188887234,,15166667234,17899999222,17812351222
 * 15188887234,15166667234,17899999222,15188887234,,15166667234
 */

import java.util.*;
/**
 * Created by wcxdhr on 2020-03-22.
 */
public class Three {
    /**
     * 总结：好好复习下排序算法吧，
     * 不稳定排序总结：一堆希尔快选
     * 稳定排序：冒泡法看看怎么写的
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        String[] ans = new String[strs.length];
        int[] values = new int[strs.length];
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            int value = scoreHelper(strs[i]);
            if (value >= 20) {
                values[count] = value;
                ans[count++] = strs[i];
            }
        }
        if (count == 0)
            System.out.print("null");
        else {
            sortPop(ans, count, values);
            for (int i = 0; i < count - 1; i++) {
                System.out.print(ans[i] + ",");

            }
            System.out.println(ans[count - 1]);
        }
    }

    private static void sortPop(String[] ans, int count, int[] values) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i; j < count - 1 - i; j++) {
                if (values[j] < values[j + 1]) {
                    String tmp = ans[j];
                    ans[j] = ans[j + 1];
                    ans[j + 1] = tmp;
                    int t = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = t;
                }
            }
        }
    }

    private static int scoreHelper(String number) {
        int plusScore = 0;
        int dupScore = 5;
        int score = 0;
        for (int i = 3; i < number.length() - 1; i++) {
            if (number.charAt(i) == number.charAt(i + 1)) {
                dupScore += 10;
                score = Math.max(score, plusScore);
                plusScore = 0;
            }
            else if (number.charAt(i) + 1 == number.charAt(i + 1)) {
                plusScore += 10;
                score = Math.max(score, dupScore);
                dupScore = 5;
            }
            else {
                score = Math.max(score, dupScore);
                score = Math.max(score, plusScore);
                plusScore = 0;
                dupScore = 5;
            }
        }
        score = Math.max(score, dupScore);
        score = Math.max(score, plusScore);
        return score;
    }

//    private static void sort(String[] ans, int low, int high, HashMap<String, Integer> map) {
//        if (low < high) {
//            int mid = getMiddle(low, high, ans, map);
//            sort(ans, low, mid - 1, map);
//            sort(ans, mid + 1, high, map);
//        }
//    }
//
//    private static int getMiddle(int low, int high, String[] ans, HashMap<String, Integer> map) {
//        String temp = ans[low];
//        int value = map.get(temp);
//        while (low < high) {
//            while (high > low && map.get(ans[high]) <= value)
//                high--;
//            if (high > low && map.get(ans[high]) > value)
//                ans[low] = ans[high];
//            while (low < high && map.get(ans[low]) >= value)
//                low++;
//            if (high > low && map.get(ans[low]) < value)
//                ans[high] = ans[low];
//        }
//        ans[low] = temp;
//        return low;
//    }
}
