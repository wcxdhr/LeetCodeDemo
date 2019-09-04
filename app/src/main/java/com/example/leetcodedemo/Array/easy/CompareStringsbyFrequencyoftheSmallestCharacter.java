package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class CompareStringsbyFrequencyoftheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] wordsFre = new int[words.length];
        for (int i = 0; i < words.length; i++)
            wordsFre[i] = getFrequency(words[i]);
        for (int i = 0; i < queries.length; i++) {
            int fre = getFrequency(queries[i]);
            for (int f : wordsFre) {
                if (f > fre)
                    ans[i]++;
            }
        }
        return ans;
    }

    public int getFrequency(String s) {
        char[] chars = s.toCharArray();
        char ansChar = chars[0];
        int countChar = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < ansChar) {
                ansChar = chars[i];
                countChar = 1;
            }
            else if (chars[i] == ansChar)
                countChar++;
        }
        return countChar;
    }
}
