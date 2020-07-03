package com.example.leetcodedemo.offercode;
/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 *
 * Allocation b c e
 * s f c s
 * Allocation d e e
 * ​
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

/**
 * Created by wcxdhr on 2020-02-25.
 */
public class MatrixHasPath {

    public static void main(String[] args) {
        System.out.println(new MatrixHasPath().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5,8,"SGGFIECVAASABCEHJIGQEM".toCharArray()));
    }


    /**
     * 递归，用一个visited数组来记录是否已经访问过，注意四个边界的检测
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (str.length == 0 || matrix.length == 0)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                boolean[] visited = new boolean[rows * cols];
                boolean cur = pathHelper(matrix, visited, rows, cols, str, i, 0);
                if (cur) return true;
            }
        }
        return false;
    }

    private boolean pathHelper(char[] matrix, boolean[] visited, int rows, int cols, char[] str, int i, int j) {
        if (i < 0 || i >= rows * cols || visited[i] || matrix[i] != str[j])
            return false;
        visited[i] = true;
        if (j == str.length - 1)
            return true;
        boolean left, right, top, bottom;
        left = right = top = bottom = false;
        if (i % cols != 0)
            left = pathHelper(matrix, visited, rows, cols, str, i - 1, j + 1);
        if ((i + 1) % cols != 0)
            right = pathHelper(matrix, visited, rows, cols, str, i + 1, j + 1);
        if (i >= cols)
            top = pathHelper(matrix, visited, rows, cols, str, i - cols, j + 1);
        if (i < (rows - 1) * cols )
            bottom = pathHelper(matrix, visited, rows, cols, str, i + cols, j + 1);
        return left || right || top || bottom;
    }
}
