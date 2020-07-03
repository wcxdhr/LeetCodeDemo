package com.example.leetcodedemo.interview.tencent;

/**
 * Created by wcxdhr on 2020-03-26.
 */
public class Two {

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println(binarySearch(new int[]{1,2,3,4,5}, 0));
        Class c = Person.class;
//        int age = c.getDeclaredField("age").get(Integer);
        System.out.println();
    }

    public static class Person{
        private int age = 1;
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }


}
