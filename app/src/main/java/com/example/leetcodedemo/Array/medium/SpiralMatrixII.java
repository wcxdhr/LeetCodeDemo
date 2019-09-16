package com.example.leetcodedemo.Array.medium;
/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/16.
 */
public class SpiralMatrixII {
    /**
     * 优化：while嵌套for循环，省略i,j的赋值
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while (count <= n * n) {
            for (int i = left; i <= right; i++)
                ans[top][i] = count++;
            top++;
            for (int i = top; i <= bottom; i++)
                ans[i][right] = count++;
            right--;
            for (int i = right; i >= left; i--)
                ans[bottom][i] = count++;
            bottom--;
            for (int i = bottom; i >= top; i--)
                ans[i][left] = count++;
            left++;
        }
        return ans;
    }
}
