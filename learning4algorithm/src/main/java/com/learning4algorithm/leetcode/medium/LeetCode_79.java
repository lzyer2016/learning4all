package com.learning4algorithm.leetcode.medium;

public class LeetCode_79 {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, word, visit, board, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, String word, boolean[][] visit, char[][] board, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visit[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visit[i][j] = true;
        if (dfs(i + 1, j, word, visit, board, index + 1) ||
                dfs(i, j + 1, word, visit, board, index + 1) ||
                dfs(i - 1, j, word, visit, board, index + 1) ||
                dfs(i, j - 1, word, visit, board, index + 1)) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }
}
