package com.example.leetcodedemo.offercode;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020-02-09.
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        new ReOrderArray().reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 1。这里我们要借鉴的排序为不改变相对位置的排序，即稳定的排序，可参考插入排序、冒泡排序
     * 2。开辟额外空间，以空间换时间
     * 下面写的是以空间换时间的算法
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] evenArr = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0)
                evenArr[count++] = array[i];
        }
        if (count == 0 || count == array.length)
            return;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                index = i;
                break;
            }
        }
        for (int i = index + 1; i < array.length; i++) {
            if ((array[i] & 1) == 1)
                array[index++] = array[i];
        }
        count = 0;
        for (int i = index; i < array.length; i++)
            array[i] = evenArr[count++];
    }
    /**
     * 这道题没做出来，我的以下解法不能保证相对位置不变
     * @param array
     */
    public void reOrderArray1(int [] array) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1)
                count++;

        }
        int i = 0;
        int j = count;
        while (i < count && j < array.length) {
            while ((array[i] & 1) == 1)
                i++;
            if (i == count)
                break;
            while ((array[j] & 1) == 0)
                j++;
            int tmp = array[i];
            array[i++] = array[j];
            array[j++] = tmp;
        }
    }
}
