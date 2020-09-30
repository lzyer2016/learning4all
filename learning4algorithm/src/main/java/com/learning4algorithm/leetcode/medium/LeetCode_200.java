package com.learning4algorithm.leetcode.medium;

public class LeetCode_200 {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, n, m, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }


    public void bfs(char[][] grid, int n, int m, int i, int j) {
        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
                bfs(grid, n, m, x, y);
            }
        }
    }
}
