package com.example.leetcodedemo.offercode;
/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

/**
 * Created by wcxdhr on 2020-02-24.
 */
public class RobotMovingCount {

    public static void main(String[] args) {
        System.out.println(new RobotMovingCount().movingCount(5,10,10));
    }


    /**
     * 书上思路即使用回溯递归的方法。
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] matrix = new boolean[rows][cols];
        return countHelper(threshold,rows,cols,0,0,matrix);
    }


    private int countHelper(int threshold, int rows, int cols, int row, int col, boolean[][] matrix) {
        int count = 0;
        if (check(threshold, rows,cols,row,col,matrix)) {
            matrix[row][col] = true;
            count = 1 + countHelper(threshold,rows,cols,row + 1,col,matrix)
                    + countHelper(threshold,rows,cols,row - 1,col,matrix)
                    + countHelper(threshold,rows,cols,row,col + 1,matrix)
                    + countHelper(threshold,rows,cols,row,col - 1,matrix);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] matrix) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
        && getDigital(row) + getDigital(col) <= threshold && !matrix[row][col]) {
            return true;
        }
        return false;
    }

    private int getDigital(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
