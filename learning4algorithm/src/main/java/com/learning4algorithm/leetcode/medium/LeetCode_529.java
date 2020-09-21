package com.learning4algorithm.leetcode.medium;

public class LeetCode_529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        int n = board.length;
        int m = board[0].length;
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int row = r + i;
                    int col = c + j;
                    if (row < 0 || row >= n || col < 0 || col >= m) {
                        continue;
                    }
                    if (board[row][col] == 'M' || board[row][col] == 'X') {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[r][c] = (char) (count + '0');
            } else {
                board[r][c] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int row = r + i;
                        int col = c + j;
                        if (row < 0 || row >= n || col < 0 || col >= m) {
                            continue;
                        }
                        if (board[row][col] == 'E') {
                            updateBoard(board, new int[]{row, col});
                        }
                    }
                }
            }
        }
        return board;
    }
}
