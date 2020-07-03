package com.example.leetcodedemo.lintcode;
/**
 * 464. 整数排序 II
 * 描述
 * 中文
 * English
 * 给一组整数，请将其在原地按照升序排序。使用归并排序，快速排序，堆排序或者任何其他 O(n log n) 的排序算法。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 例1：
 *
 * 输入：[3,2,1,4,5]，
 * 输出：[1,2,3,4,5]。
 * 例2：
 *
 * 输入：[2,3,1]，
 * 输出：[1,2,3]。
 */

import android.os.SystemPropertiesProto;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020-03-30.
 */
public class SortIntegersII {

    /**
     * 快速排序
     * @param A
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = getMiddle(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

    private int getMiddle(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] > tmp)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] < tmp)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    /**
     * 归并排序
     * @param A
     */
    public void sortIntegers21(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= high)
            tmp[k++] = nums[j++];
        for (k = 0; k < tmp.length; k++) {
            nums[k + low] = tmp[k];
        }
    }


    public static void main(String[] args) {
        int[] A = new int[]{1,3,4,2,45,56,3};
        new SortIntegersII().sortIntegers22(A);
        System.out.println(Arrays.toString(A));
    }
    /**
     * 堆排
     * 注意：for循环：len - 1， 每次把0位置与当前最后一个位置交换
     * @param A
     */
    public void sortIntegers22(int[] A) {
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            buildMaxHeap(A, len - i - 1);
            swap(A, 0, len - i - 1);
        }

    }

    // 1 2 3 4 5, 1:2 3, 2: 4 5

    /**
     * 注意：
     * 循环起点：(last - 1) / 2
     * k节点的左子节点：k*2+1，右子节点：k*2+2
     * 流程：先与两个子节点作比较，交换之后，再往下调整（所以是while循环）
     * @param A
     * @param last
     */
    private void buildMaxHeap(int[] A, int last) {
        for (int i = (last - 1) / 2; i >= 0; i--) {
            int k = i;
            while (k * 2 + 1 <= last) {
                int biggerIndex = k * 2 + 1;
                if (biggerIndex < last && A[biggerIndex] < A[biggerIndex + 1])
                    biggerIndex++;
                if (A[biggerIndex] > A[k]) {
                    swap(A, biggerIndex, k);
                    k = biggerIndex;
                }
                else break;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
