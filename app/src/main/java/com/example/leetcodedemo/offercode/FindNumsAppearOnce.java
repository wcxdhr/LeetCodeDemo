package com.example.leetcodedemo.offercode;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

import java.util.HashSet;

/**
 * Created by wcxdhr on 2020-02-15.
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果

    /**
     * 这道题没有思路，书上说用异或来解决
     * 位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor1 = 0;
        for(int i=0; i < array.length; i++)
            xor1 = xor1^array[i];
        //在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        int index = 1;
        while((index & xor1)==0)
            index = index <<1;//因为可能有多个位为1所以需要求一下位置
        int result1 = 0;
        int result2 = 0;
        for(int i=0; i < array.length; i++){
            if((index & array[i]) == 0)
                result1 = result1^array[i];
            else
                result2 = result2^array[i];
        }
        num1[0] = result1;
        num2[0] = result2;

    }
}
