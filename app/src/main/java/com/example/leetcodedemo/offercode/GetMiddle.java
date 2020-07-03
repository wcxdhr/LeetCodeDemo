package com.example.leetcodedemo.offercode;
/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wcxdhr on 2020-02-26.
 */
public class GetMiddle {


    /**
     * 题解：很巧妙，用一个大顶堆和一个小顶堆，一个存储比较小的一半数字，一个存储比较大的一半数字，
     * 确保两个堆数字差值小于等于1.
     * @param num
     */

    private PriorityQueue<Integer> big = new PriorityQueue<>();
    private PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer integer, Integer t1) {
            return t1 - integer;
        }
    });

    public void Insert(Integer num) {
        if (small.isEmpty())
            small.add(num);
        else if (big.isEmpty()) {
            if (num < small.peek()) {
                int tmp = small.remove();
                small.add(num);
                big.add(tmp);
            }
            else big.add(num);
        }
        else if (num < big.peek()) {
            if (small.size() == big.size())
                small.add(num);
            else if (small.size() > big.size()){
                if (num >= small.peek())
                    big.add(num);
                else {
                    int tmp = small.remove();
                    small.add(num);
                    big.add(tmp);
                }
            }
        }
        else {
            if (small.size() > big.size())
                big.add(num);
            else {
                int tmp = big.remove();
                big.add(num);
                small.add(tmp);
            }
        }
    }

    public Double GetMedian() {
        if ((small.size() == big.size() + 1))
            return (double)small.peek();
        else return (small.peek() + big.peek()) / 2.0;
    }



    /**
     * 这个思路非常朴素
     */
    ArrayList<Integer> arr = new ArrayList<>();
    public void Insert1(Integer num) {
        if (arr.size() == 0)
            arr.add(num);
        else {int i;
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i) > num) {
                    arr.add(i, num);
                    break;
                }
            }
            if (i == arr.size())
                arr.add(num);
        }
    }

    public Double GetMedian2() {
        int len = arr.size();
        if (len > 0)
            return (len & 1) == 0 ? ((arr.get(len >> 1) + arr.get((len >> 1) - 1)) / 2) : (double)arr.get(len >> 1);
        return 0.0;
    }

}
