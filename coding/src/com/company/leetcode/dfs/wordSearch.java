package com.company.leetcode.dfs;

/**
 * @author xxy
 * @date 2019/8/31
 * @description
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] used = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (helper(board, used, word.toCharArray(), 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, boolean[][] used, char[] word, int idx, int row, int col) {
        if (idx == word.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (used[row][col] == true || board[row][col] != word[idx]) {
            return false;
        }
        used[row][col] = true;

        if (helper(board, used, word, idx + 1, row, col + 1) ||
                helper(board, used, word, idx + 1, row + 1, col) ||
                helper(board, used, word, idx + 1, row - 1, col) ||
                helper(board, used, word, idx + 1, row, col - 1)) {
            return true;
        }
        used[row][col] = false;
        return false;
    }
}
