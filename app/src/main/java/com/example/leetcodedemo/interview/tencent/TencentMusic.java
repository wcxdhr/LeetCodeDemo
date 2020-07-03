package com.example.leetcodedemo.interview.tencent;
/**
 * 1. array 升序
 * 2. boolean func(int sum) -> sum = array[x]+array[y]
 */

/**
 * Created by wcxdhr on 2020-04-08.
 */
public class TencentMusic {

    public static void main(String[] args){
            System.out.println(findSum(new int[]{1,2,3,4,5}, 5));
    }


    public static boolean findSum(int[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        int cur;
        while (i < j) {
            cur = array[i] + array[j];
            if (cur == sum)
                return true;
            else if (cur < sum)
                i++;
            else j--;
        }
        return false;
    }
}
