package com.example.leetcodedemo.offercode;
/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * Created by wcxdhr on 2020/2/4.
 */

public class ArrayFind {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new ArrayFind().Find(7, arr));
    }

    /**
     * 官方解答
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int colLen = array.length;
        if (colLen == 0)
            return false;
        int rowLen = array[0].length;
        if (rowLen == 0 || array[0][0] > target || array[colLen - 1][rowLen - 1] < target)
            return false;
        int row = 0, col = colLen - 1;
        while (row < rowLen && col >= 0) {
            if (array[row][col] == target)
                return true;
            else if (array[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }


    /**
     * 这个题意不清楚啊，case中只是每一行第一个递增，整个数组不是严格递增的
     * 按照case做修改.
     * 思路是按行来查找，还是官方解答比较巧妙
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int [][] array) {
        int colLen = array.length;
        if (colLen == 0)
            return false;
        int rowLen = array[0].length;
        if (rowLen == 0 || array[0][0] > target || array[colLen - 1][rowLen - 1] < target)
            return false;
        for (int i = 0; i < colLen; i++) {
            if (array[i][0] <= target && array[i][rowLen - 1] >= target )
                if (findHelper(target, array[i], rowLen))
                    return true;
            else if (array[i][0] > target)
                break;
        }
        return false;
    }

    private boolean findHelper(int target, int [] array, int rowLen) {
        int rowLow = 0;
        int rowHigh = rowLen;
        int rowMid;
        while (rowLow <= rowHigh) {
            rowMid = (rowHigh + rowLow) / 2;
            if (array[rowMid] == target)
                return true;
            else if (array[rowMid] > target)
                rowHigh = rowMid - 1;
            else
                rowLow = rowMid + 1;
        }
        return false;
    }
}
