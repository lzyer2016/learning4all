package com.learning4algorithm.leetcode.medium;

public class Count_Square_Submatrices_with_All_Ones {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ant = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0 && j > 0 && i > 0) {
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;
                }
                ant += matrix[i][j];
            }
        }
        return ant;
    }
}
