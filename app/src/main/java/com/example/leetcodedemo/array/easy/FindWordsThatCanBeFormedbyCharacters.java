package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class FindWordsThatCanBeFormedbyCharacters {

    /**
     * 用HashMap， String可转化为char数组
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        int[] countChars = new int[26];
        for (int i = 0; i < chars.length(); i++)
            countChars[chars.charAt(i) - 'a']++;
        int[][] countWords = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++)
                countWords[i][words[i].charAt(j) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (countChars[words[i].charAt(j) - 'a'] < countWords[i][words[i].charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += words[i].length();
            }
        }
        return sum;
    }
}
