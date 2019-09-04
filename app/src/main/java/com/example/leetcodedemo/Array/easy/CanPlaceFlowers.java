package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/27.
 */

public class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0}, 1));
    }

    /**
     * 代码太繁琐，可优化：去掉sum，去掉头尾处理
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        int i = 0;
        if (n == 0)
            return true;
        if (flowerbed.length == 1)
            return n == 1?(flowerbed[0]==0):false;
        if (flowerbed[0] == flowerbed[1]) {
            flowerbed[0] = 1;
            sum++;
        }
        i++;
        while (i < flowerbed.length - 1){
            if (flowerbed[i] == flowerbed[i - 1] && flowerbed[i] == flowerbed[i + 1]) {
                flowerbed[i] = 1;
                sum++;
            }
            if (flowerbed[i] == 1)
                i +=2;
            else
                i++;
        }
        if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0)
            sum++;
        if (sum >= n)
            return true;
        return false;
    }
}
