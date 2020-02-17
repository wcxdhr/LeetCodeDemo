package com.example.leetcodedemo.offercode;
/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

/**
 * Created by wcxdhr on 2020-02-16.
 */
public class GetUglyNumber {
    /**
     * 这道题没什么特殊解法，需要穷举，问题的关键就是三个指针分别记录最后的2，3，5倍的丑数的下标
     * 并更新
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] ugly = new int[index + 1];
        ugly[1] = 1;
        int t2 = 1, t3 =1, t5 = 1;
        for (int i = 2; i < ugly.length; i++) {
            ugly[i] = ugly[t2] * 2;
            ugly[i] = Math.min(ugly[t3] * 3, ugly[i]);
            ugly[i] = Math.min(ugly[t5] * 5, ugly[i]);
            if (ugly[i] == ugly[t2] * 2) t2++;
            if (ugly[i] == ugly[t3] * 3) t3++;
            if (ugly[i] == ugly[t5] * 5) t5++;
        }
        return ugly[index];
    }
}
