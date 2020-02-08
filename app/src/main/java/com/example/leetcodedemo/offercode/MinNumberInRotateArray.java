package com.example.leetcodedemo.offercode;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/**
 * Created by wcxdhr on 2020/2/6.
 */

public class MinNumberInRotateArray {

    /**
     * 采用最简单的方法
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return array[0];
    }

    /**
     * 二分法的关键是这个非递减的特例，例如2，3，2，2，2，2，2
     * 我就卡在这里，官方解答是直接判断是不是特例，是的话顺序查找。
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        int len = array.length;
        if (len == 0)
            return 0;
        int low = 0;
        int high = len - 1;
        int mid = (low + high) / 2;;
        if (array[low] == array[mid] || array[low] == array[high]
        || array[mid] == array[high]) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1])
                    return array[i];
            }
            return array[0];
        }
        if (array[low] < array[high])
            return array[0];
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] != 0 && array[mid] < array[mid - 1])
                return array[mid];
            else if (array[mid] < array[len - 1])
                high = mid - 1;
            else if (array[mid] > array[0])
                low = mid + 1;
        }
        return 0;
    }
}
