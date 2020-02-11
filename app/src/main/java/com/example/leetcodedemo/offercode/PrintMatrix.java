package com.example.leetcodedemo.offercode;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;

/**
 * Created by wcxdhr on 2020-02-11.
 */
public class PrintMatrix {

    public static void main(String[] args) {
        System.out.println(new PrintMatrix().printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));

    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int right = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;
        int len = matrix.length * matrix[0].length;
        while (len > ans.size()) {
            for (int col = left; col <= right; col++)
                ans.add(matrix[top][col]);
            top++;
            if (top > bottom)
                break;
            for (int row = top; row <= bottom; row++)
                ans.add(matrix[row][right]);
            right--;
            if (right < left)
                break;
            for (int col = right; col >= left; col--)
                ans.add(matrix[bottom][col]);
            bottom--;
            if (bottom < top)
                break;
            for (int row = bottom; row >= top; row--)
                ans.add(matrix[row][left]);
            left++;
        }
        return ans;
    }


    /**
     * 可以省略i，j，用while嵌套for循环，修改后的代码在上面
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix1(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int direction = 0;
        int right = matrix[0].length;
        int left = -1;
        int top = -1;
        int bottom = matrix.length;
        int i = 0, j = 0;
        int len = right * bottom;
        while (len > ans.size()) {
            switch (direction) {
                case 0:
                    while (j < right)
                        ans.add(matrix[i][j++]);
                    top++;
                    i++;
                    j--;
                    direction = 1;
                    break;
                case 1:
                    while (i < bottom)
                        ans.add(matrix[i++][j]);
                    right--;
                    i--;
                    j--;
                    direction = 2;
                    break;
                case 2:
                    while (j > left)
                        ans.add(matrix[i][j--]);
                    bottom--;
                    i--;
                    j++;
                    direction = 3;
                    break;
                case 3:
                    while (i > top)
                        ans.add(matrix[i--][j]);
                    left++;
                    i++;
                    j++;
                    direction = 0;
                    break;
            }
        }
        return ans;
    }
}
