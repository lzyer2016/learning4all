package com.learning4algorithm.leetcode.easy;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 */
public class Solution1351 {

    public int countNegatives(int[][] grid) {
        if (grid == null)
            return 0;
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    ret++;
                } else {
                    break;
                }
            }
        }
        return ret;
    }
}
