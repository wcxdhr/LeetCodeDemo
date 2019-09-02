package com.example.leetcodedemo.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class FindCommonCharacters {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bdgfhthkjvgh"}));
    }

    /**
     * 直接使用String，去除char的转换
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        int[][] wordCount = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                wordCount[i][(A[i].charAt(j)) - 'a']++;
            }
        }
        List<String> chars = new ArrayList<>();
        int j = 0;
        while (j < 26){
            boolean flag = true;
            while (flag) {
                for (int i = 0; i < A.length; i++) {
                    if (wordCount[i][j] == 0) {
                        flag = false;
                        break;
                    }
                    else
                        wordCount[i][j]--;
                    if (i == A.length - 1)
                        chars.add(String.valueOf((char)(j + 'a')));
                }
            }
            j++;
        }
        return chars;
    }
}
