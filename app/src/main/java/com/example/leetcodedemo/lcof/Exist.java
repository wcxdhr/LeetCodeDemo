package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 */

/**
 * Created by wcxdhr on 2020-06-23.
 */
public class Exist {

    /**
     * dfs,辅助函数递归回溯，visited数组记录访问
     *
     * 参考题解中有人用tmp记录board[x][y]此时的值，省去visited数组
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    boolean[][] visited = new boolean[200][200];

    private boolean existHelper(char[][] board, String word, int i, int x, int y) {

        //注意边界条件，开闭区间
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] ||  board[x][y] != word.charAt(i))
            return false;
        else {
            visited[x][y] = true;
            if (i == word.length() - 1 || existHelper(board, word, i + 1, x - 1, y) ||
                    existHelper(board, word, i + 1, x + 1, y) || existHelper(board, word, i + 1, x, y - 1) ||
                    existHelper(board, word, i + 1, x, y + 1))
                return true;
            else {
                visited[x][y] = false;
                return false;
            }
        }
    }
}
