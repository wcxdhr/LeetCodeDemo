package com.example.leetcodedemo.math.easy;
/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashSet;

/**
 * Created by Wcxdhr on 2019/12/31.
 */
public class HappyNumber {

    /**
     * 我的思路：HashSet 3ms， 32.27%，时间效率一般
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            int tmp = n;
            n = 0;
            while (tmp > 0) {
                n += Math.pow((tmp % 10), 2);
                tmp = tmp / 10;
            }
        }
        return true;
    }

    /**
     * 改进1：去掉Math.pow函数，使用临时变量t*t，时间2ms，66.57%
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            int tmp = n;
            n = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                n += t * t;
                tmp = tmp / 10;
            }
        }
        return true;
    }

    /**
     * 别人的题解：借鉴链表快慢指针方法判断循环 1ms 100%
     * @param n
     * @return
     */
    public boolean isHappy3(int n) {
        int slow = n, fast = n;
        do {
            slow = happyHelper(slow);
            fast = happyHelper(fast);
            fast = happyHelper(fast);
        }while (slow != fast);
        if (slow == 1)
            return true;
        else return false;
    }

    private int happyHelper(int n) {
        int tmp = n;
        n = 0;
        while (tmp > 0) {
            int t = tmp % 10;
            n += t * t;
            tmp = tmp / 10;
        }
        return n;
    }

}
