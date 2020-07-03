package com.example.leetcodedemo.lintcode;
/**
 * 463. 整数排序
 * 描述
 * 中文
 * English
 * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例  1:
 * 	输入:  [3, 2, 1, 4, 5]
 * 	输出:  [1, 2, 3, 4, 5]
 *
 * 	样例解释:
 * 	返回排序后的数组。
 *
 * 样例 2:
 * 	输入:  [1, 1, 2, 1, 1]
 * 	输出:  [1, 1, 1, 1, 2]
 *
 * 	样例解释:
 * 	返回排好序的数组。
 */

/**
 * Created by wcxdhr on 2020-03-30.
 */
public class SortIntegers {
    /**冒泡排序
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        for (int i = 0; i < A.length; i++) {
            boolean flag = false;
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    /**
     * 选择排序
     * 关键是找最小值的位置
     * 时间复杂度O(n*n) 性能上优于冒泡排序 交换次数少
     * @param A
     */
    public void sortIntegers1(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int index = i;
            for (int j = i; j < A.length; j++) {
                if (A[j] < A[index]) {
                    index = j;
                }
            }
            int tmp = A[i];
            A[i] = A[index];
            A[index] = tmp;
        }
    }

    /**
     * 插入排序
     * 注意比较时，从后往前比，如果小，就后移一位
     * O(n*n) 性能上优于冒泡排序和选择排序
     * @param A
     */
    public void sortIntegers2(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int tmp = A[i];
            int j = i;
            while (j >= 1 && A[j - 1] > tmp) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tmp;
        }
    }
}
