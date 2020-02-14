package com.example.leetcodedemo.offercode;
/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

/**
 * Created by wcxdhr on 2020-02-14.
 */
public class Duplicate {


    public static void main(String[] args) {
        System.out.println(new Duplicate().duplicate(new int[]{2,1,3,1,4}, 5, new int[1]));
    }
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * leetcode上有原题，就原数组替换下标。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int i = 0;
        while (i < length) {
            if (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                else {
                    int tmp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[tmp] = tmp;
                }
            }
            else i++;
        }
        return false;
    }
}
