package com.learning4algorithm.leetcode.medium;

public class LeetCode_1706 {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0, z = 0, y = i;
            while (j < n) {
                if (z == 0) {
                    if (grid[j][y] == 1) {
                        if (y + 1 >= m || grid[j][y + 1] == -1) y = -1;
                        else {
                            y++;
                            z = 1;
                        }
                    } else {
                        if (y - 1 < 0 || grid[j][y - 1] == 1) y = -1;
                        else {
                            y--;
                            z = 1;
                        }
                    }
                } else {
                    j++;
                    z = 0;
                }
                if (y == -1) break;
            }
            res[i] = y;
        }
        return res;
    }
}
