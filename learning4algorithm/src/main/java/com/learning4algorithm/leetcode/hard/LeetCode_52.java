package com.learning4algorithm.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_52 {

    private Set<Integer> colSet = new HashSet<>();

    private Set<Integer> colDiag1 = new HashSet<>();

    private Set<Integer> colDiag2 = new HashSet<>();

    public int totalNQueens(int n) {
        return help(0, n, 0);
    }

    public int help(int row, int n, int count) {
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col)) {
                continue;
            }
            int diag1 = row - col;
            if (colDiag1.contains(diag1)) {
                continue;
            }
            int diag2 = row + col;
            if (colDiag2.contains(diag2)) {
                continue;
            }
            if (row == n - 1) {
                count++;
            } else {
                colSet.add(col);
                colDiag1.add(diag1);
                colDiag2.add(diag2);
                count = help(row + 1, n, count);
                colSet.remove(col);
                colDiag1.remove(diag1);
                colDiag2.remove(diag2);
            }
        }
        return count;
    }
}
