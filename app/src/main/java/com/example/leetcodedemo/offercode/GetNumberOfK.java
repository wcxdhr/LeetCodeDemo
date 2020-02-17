package com.example.leetcodedemo.offercode;
/**
 * 统计一个数字在排序数组中出现的次数。
 */

/**
 * Created by wcxdhr on 2020-02-15.
 */
public class GetNumberOfK {

    /**
     * 书上觉得这样时间效率不够高，应该要先找出第一个k，再找出最后一个k，直接算出差值。
     * 找k时的二分搜索则要判断此时是否是第一个k（index-1是否是k）等
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if (len == 0 || array[0] > k || array[len - 1] < k)
            return 0;
        int low = 0;
        int high = len - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (array[mid] == k)
                break;
            else if (array[mid] < k)
                low = mid + 1;
            else high = mid - 1;
        }
        int ans = 0;
        if (array[mid] == k) {
            for (int i = mid; i >= 0; i--){
                if (array[i] == k)
                    ans++;
                else
                    break;
            }
            for (int i = mid + 1; i < len; i++) {
                if (array[i] == k)
                    ans++;
                else
                    break;
            }
        }
        return ans;
    }
}
