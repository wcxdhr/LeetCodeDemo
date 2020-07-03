package com.example.leetcodedemo.interview.kuaishou;
import java.util.*;
import java.io.*;
/**
 * Created by wcxdhr on 2020-03-22.
 */
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max && nums[i] >= second)
                ans.add(i);
            if (nums[i] > max) {
                second = max;
                max = nums[i];
            }
            else if (nums[i] > second)
                second = nums[i];

        }
        if (ans.size() == 0)
            System.out.print(-1);
        else {
            for (int i = 0; i < ans.size() - 1; i++) {
                System.out.print(ans.get(i) + " ");

            }
            System.out.println(ans.get(ans.size() - 1));
        }
    }


}
