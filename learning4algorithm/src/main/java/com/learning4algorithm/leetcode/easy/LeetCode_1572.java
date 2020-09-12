package com.learning4algorithm.leetcode.easy;

public class LeetCode_1572 {

    public int diagonalSum(int[][] mat) {
        int ret = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            ret += mat[i][i];
            ret += mat[i][n - i - 1];
        }
        if ((n & 1) == 1) {
            ret -= mat[n / 2][n / 2];
        }
        return ret;
    }
}
