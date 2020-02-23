package com.example.leetcodedemo.offercode;
/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wcxdhr on 2020-02-23.
 */
public class FirstAppearingOnceChar {
    //Insert one char from stringstream

    /**
     * 书上的思路是用数组模拟哈希表，记住字符一共256个，所以可以确定大小，最开始数组所有元素都为-1，
     * 当ASCII玛为的字符第一次读出时，数组第i项更新为它在字符流中的位置，当字符第二次读出时，
     * 更新为-2。因此每次查找时遍历256的数组就能找到满足条件的字符。
     */
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch)
    {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return '#';
    }
}
