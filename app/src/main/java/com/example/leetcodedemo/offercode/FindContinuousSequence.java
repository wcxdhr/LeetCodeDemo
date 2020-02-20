package com.example.leetcodedemo.offercode;
/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为s的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;

/**
 * Created by wcxdhr on 2020-02-19.
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().FindContinuousSequence(9));
    }


    /**
     * 官方题解，参考和为s的联系递增序列，用双指针来实现
     * 初始化small为1，big为2，然后先增大big，当和大于s后增大small，以此类推
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int small = 1;
        int big = 2;
        int middle = (1 + sum) >> 1;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                ArrayList<Integer> sub = new ArrayList<>();
                for (int i = small; i <= big; i++)
                    sub.add(i);
                ans.add(sub);
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    ArrayList<Integer> sub = new ArrayList<>();
                    for (int i = small; i <= big; i++)
                        sub.add(i);
                    ans.add(sub);
                }
            }
            big++;
            curSum += big;
        }
        return ans;
    }
    /**
     * 我的思路，不停找合适的中间值，来找到序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int tmp = 0;
        int i;
        for (i = 1; i < sum; i++) {
             tmp += i;
             if (tmp > sum)
                 break;
        }
        int count = i;
        for (i = count - 1; i >= 2; i--) {
            int rest = sum % i;
             if (((i & 1) == 1) && (rest == 0) || ((i & 1) == 0) && (i == rest << 1)) {
                 int index = (sum / i) - ((i & 1) == 1 ? (i >> 1) : (i >> 1) - 1);
                 ArrayList<Integer> sub = new ArrayList<>();
                 for (int j = index; j < index + i; j++)
                     sub.add(j);
                 ans.add(sub);
             }

        }
        return ans;
    }
}
