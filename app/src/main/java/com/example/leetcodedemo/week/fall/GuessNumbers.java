package com.example.leetcodedemo.week.fall;

/**
 * Created by wcxdhr on 2019/9/24.
 */

public class GuessNumbers {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
             if (guess[i] == answer[i])
                 count++;
        }
        return count;
    }
}
