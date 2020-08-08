package com.learning4algorithm.leetcode.medium;

public class LeetCode_980 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int ans;
    int tr;
    int tc;

    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sr = 0, sc = 0;
        int todo = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    tr = i;
                    tc = j;
                } else if (grid[i][j] != -1) {
                    todo++;
                }
            }
        }
        ans = 0;
        dfs(grid, sr, sc, todo);
        return ans;
    }

    public void dfs(int[][] grid, int r, int c, int todo) {
        todo--;
        if (todo < 0) return;
        if (r == tr && c == tc) {
            if (todo == 0) {
                ans++;
            }
            return;
        }
        grid[r][c] = 3;
        for (int k = 0; k < 4; k++) {
            int nr = r + dx[k];
            int nc = c + dy[k];
            if (0 <= nr && nr < grid.length && 0 <= nc && nc < grid[0].length) {
                if (grid[nr][nc] % 2 == 0) {
                    dfs(grid, nr, nc, todo);
                }
            }
        }
        grid[r][c] = 0;
    }
}
