package com.example.leetcodedemo.interview.ali.practice;
/**
 * 作者：牛客672256790号
 * 链接：https://www.nowcoder.com/discuss/387206?type=post&order=time&pos=&page=1
 * 来源：牛客网
 *
 * 1. 一副扑克牌，总共有 A 2 3 4 5 6 7 8 9 10 每张牌各4张，从中抽取任意张牌，牌可以有四种出法
 *
 * 1. 单张牌，比如说 A
 * 2. 一对牌，比如说 两个2
 * 3. 五张牌顺子，比如说 A 2 3 4 5
 * 4. 六张牌连对，比如说 A A 2 2 3 3
 *
 * 现在输入是10种牌每张牌的个数，如 1 1 1 2 2 2 2 2 1 1 ，指的是这10张牌每张的个数，
 * 现在问最少出几次能把牌出完。
 *
 * 此时的解答是3次，出3个顺子可以达到目标。
 */
import java.util.*;
/**
 * Created by wcxdhr on 2020-03-23.
 */
public class Poker {

    private static class PokerState{
        int num;
        int dp;
        boolean isSingle  = true;
        boolean isDouble;
        boolean isContinuous;
        boolean isDoubleThree;
        public PokerState(int num){
            this.num = num;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PokerState[] pokers = new PokerState[11];
        pokers[0] = new PokerState(0);
        for (int i = 1; i <= 10; i++) {
            pokers[i] = new PokerState(in.nextInt());
        }
        System.out.println(pokerHelper(pokers));
    }

    /**
     * 这个解法有问题呀
     * @param pokers
     * @return
     */
    private static int pokerHelper(PokerState[] pokers) {
        int doubleCount = 0;
        int continuousCount = 0;
        int doubleThreeCount = 0;
        pokers[0].dp = 0;
        for (int i = 1; i <= 10; i++) {
            pokers[i].dp = pokers[i - 1].dp + pokers[i].num;
            if (pokers[i].num == 0) {
                doubleCount = continuousCount = doubleThreeCount = 0;
                continue;
            } else if (pokers[i].num > 1) {
                doubleCount += pokers[i].num >> 1;
                doubleThreeCount += pokers[i].num >> 1;
            } else {
                doubleCount = doubleThreeCount = 0;
            }
            continuousCount++;
            if (continuousCount >= 5)
                pokers[i].dp = Math.min(pokers[i].dp, pokers[i - 5].dp + 1);
            if (doubleCount >= 1)
                pokers[i].dp = Math.min(pokers[i].dp, pokers[i - 1].dp + 1);
            if (doubleThreeCount >= 3)
                pokers[i].dp = Math.min(pokers[i].dp, pokers[i - 3].dp + 1);
        }
        return pokers[10].dp;
    }
}
