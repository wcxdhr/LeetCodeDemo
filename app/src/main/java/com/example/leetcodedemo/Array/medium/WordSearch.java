package com.example.leetcodedemo.Array.medium;
/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/17.
 */
public class WordSearch {


    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(wordSearch.exist(board, "SEE"));
    }

    /**
     * 可以使用偏移量数组简化问题
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] uesd = new boolean[board.length][board[0].length];
                    if (findWord(uesd, board, word, i, j, 1))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(boolean[][] used, char[][] board, String word, int row, int col, int index) {
        used[row][col] = true;
        if (index == word.length())
            return true;
        if (row + 1 < board.length && !used[row + 1][col] && board[row + 1][col] == word.charAt(index))
            if (findWord(used, board, word, row + 1, col, index + 1))
                return true;
        if (col + 1 < board[0].length && !used[row][col + 1] && board[row][col + 1] == word.charAt(index))
            if (findWord(used, board, word, row, col + 1, index + 1))
                return true;
        if (row - 1 >=0 && !used[row - 1][col] && board[row - 1][col] == word.charAt(index))
            if (findWord(used, board, word, row - 1, col, index + 1))
                return true;
        if (col - 1 >= 0 && !used[row][col - 1] && board[row][col - 1] == word.charAt(index))
            if (findWord(used, board, word, row, col - 1, index + 1))
                return true;
        used[row][col] = false;
        return false;
    }
}
