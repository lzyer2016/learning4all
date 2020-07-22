package com.learning4algorithm.leetcode.medium;

public class Path_with_Maximum_Gold {
                    // up down left right
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};


    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j, n, m));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 0;
        }
        int origin = grid[x][y];
        grid[x][y] = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, dfs(grid, x + dx[i], y + dy[i], n, m));
        }
        grid[x][y] = origin;
        return max + origin;
    }
}
