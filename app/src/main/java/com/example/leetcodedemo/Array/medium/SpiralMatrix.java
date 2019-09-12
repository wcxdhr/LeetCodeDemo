package com.example.leetcodedemo.Array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * Created by Wcxdhr on 2019/9/11.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int left = -1;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        int len = matrix[0].length * matrix.length;
        int direction = 0;
        int i = 0;
        int j = 0;
        while (len > 0){
            switch (direction) {
                case 0:
                    while (j < right) {
                        ans.add(matrix[i][j++]);
                        len--;
                    }
                    j--;
                    i++;
                    right--;
                    direction = 1;
                    break;
                case 1:
                    while (i < bottom){
                        ans.add(matrix[i++][j]);
                        len--;
                    }
                    i--;
                    j--;
                    bottom--;
                    direction = 2;
                    break;
                case 2:
                    while (j > left){
                        ans.add(matrix[i][j--]);
                        len--;
                    }
                    j++;
                    i--;
                    left++;
                    direction = 3;
                    break;
                case 3:
                    while (i > top){
                        ans.add(matrix[i--][j]);
                        len--;
                    }
                    i++;
                    j++;
                    top++;
                    direction = 0;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
