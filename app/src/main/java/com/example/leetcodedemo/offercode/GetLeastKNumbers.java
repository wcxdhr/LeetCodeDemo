package com.example.leetcodedemo.offercode;
/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.ArrayList;

/**
 * Created by wcxdhr on 2020-02-12.
 */
public class GetLeastKNumbers {


    public static void main(String[] args) {
        System.out.println(new GetLeastKNumbers().GetLeastNumbers_Solution(new int[]{
                4,5,1,6,2,7,3,8
        }, 10));
    }

    /**
     * 这道题没想到什么好的解法，书上说可以用分治法，修改原数组，达到o(n)的时间效率
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int low = 0;
        int high = input.length - 1;
        if (k > input.length || k <= 0)
            return ans;
        int index = partition(input, low, high);
        while (index != k - 1) {
            if (index < k - 1) {
                low = index + 1;
                index = partition(input, low, high);
            }
            else {
                high = index - 1;
                index = partition(input, low, high);
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);

        }
        return ans;
    }

    /**
     * 加了k的边界检测之后，把input[high] > temp改成 input[high] >= temp才通过
     * @param input
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] input, int low, int high) {
        int temp = input[low];
        while (low < high) {
            while (low < high && input[high] >= temp)
                high--;
            input[low] = input[high];
            while (low < high && input[low] <= temp)
                low++;
            input[high] = input[low];
        }
        input[low] = temp;
        return low;
    }
}
