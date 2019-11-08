package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/9/2.
 */

public class MaximizeDistancetoClosestPerson {

    /**
     * 更优解法：找最大0距离，一遍循环
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int index = -1;
        int ans = 1;
        int[] minDist = new int[seats.length];
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                index = i;
            }
            else if (index != -1)
                minDist[i] = i - index;

        }
        index = -1;
        for(int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 1)
                index = i;
            else {
                if (index != -1){
                    minDist[i] = minDist[i] != 0 ? Math.min(minDist[i], index - i) : index - i;
                }
                ans = Math.max(minDist[i], ans);
            }
        }
        return ans;
    }
}
