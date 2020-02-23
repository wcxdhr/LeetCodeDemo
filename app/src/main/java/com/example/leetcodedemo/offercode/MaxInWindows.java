package com.example.leetcodedemo.offercode;
/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wcxdhr on 2020-02-23.
 */
public class MaxInWindows {

    public static void main(String[] args) {
        System.out.println(new MaxInWindows().maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }

    private PriorityQueue<Integer> maxTree = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer integer, Integer t1) {
            return t1 - integer;
        }
    });
    /**
     * 题解思路：用大顶堆来保存滑窗口
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        int len = num.length;
        if (len == 0 || size <= 0 || size > len) return ans;
        for (int i = 0; i < size; i++) {
            maxTree.add(num[i]);
        }
        ans.add(maxTree.peek());
        for (int i = size; i < num.length; i++) {
            maxTree.remove(num[i - size]);
            maxTree.add(num[i]);
            ans.add(maxTree.peek());
        }
        return ans;
    }
    /**
     * 我的思路：朴素的滑动窗口
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int len = num.length;
        if (len == 0 || size <= 0 || size > len) return ans;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (num[i] >= max) {
                max = num[i];
                index = i;
            }
        }
        ans.add(max);
        for (int i = size; i < num.length; i++) {
            if (num[i] >= max) {
                max = num[i];
                index = i;
            }
            else if (index == i - size) {
                max = num[index + 1];
                index++;
                for (int j = index + 1; j <= i; j++) {
                    if (num[j] >= max) {
                        max = num[j];
                        index = j;
                    }
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
