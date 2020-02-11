package com.example.leetcodedemo.offercode;
/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020-02-11.
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }

    /**
     * 摩尔投票法，多数获胜，如果当前数字与member相同，count++，否则--，当count = 0时就同归于尽
     * 选取新的候选member，则最后一个count >= 1时的member获胜
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int member = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                member = array[i];
                count = 1;
                continue;
            }
            if (array[i] == member)
                count++;
            else
                count--;
        }
        count = 0;
        /**
         * 这里要检查一下member是否超过了数组的一半
         */
        for (int i = 0; i < array.length; i++) {
            if (array[i] == member)
                count++;

        }
        return count << 1 > array.length ? member : 0;
    }
    /**
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array.length == 1)
            return array[0];
        Arrays.sort(array);
        int start = 0;
        int halfLen = array.length >> 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1])
                if (i - start + 1 > halfLen)
                    return array[i];
                else
                    start = i + 1;
        }
        return 0;
    }
}
