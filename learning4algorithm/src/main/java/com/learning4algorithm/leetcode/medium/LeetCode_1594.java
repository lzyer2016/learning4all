package com.learning4algorithm.leetcode.medium;

public class LeetCode_1594 {

    int mod = 1000000007;

    double product = -1;

    public int maxProductPath(int[][] grid) {
        bfs(grid, 0, 0, grid[0][0]);
        return (int) (product % mod);
    }

    public void bfs(int[][] grid, int i, int j, double cur) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            product = Math.max(product, cur);
            return;
        }
        if (grid[i][j] == 0) {
            product = Math.max(product, 0);
            return;
        }
        if (i + 1 < grid.length - 1) {
            bfs(grid, i + 1, j, cur * grid[i + 1][j]);
        }
        if (j + 1 < grid[0].length - 1) {
            bfs(grid, i, j + 1, cur * grid[i][j + 1]);
        }
    }
}
