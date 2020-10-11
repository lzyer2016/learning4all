package com.learning4algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_542 {

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return matrix;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }
                queue.add(new int[]{x, y});
                matrix[x][y] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
}
