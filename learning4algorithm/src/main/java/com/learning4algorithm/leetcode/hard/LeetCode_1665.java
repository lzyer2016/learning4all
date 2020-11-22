package com.learning4algorithm.leetcode.hard;

public class LeetCode_1665 {

    public int minimumEffort(int[][] tasks) {
        int max = 0, minDiff = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < tasks.length; i++) {
            res += tasks[i][0];
            max = Math.max(max, tasks[i][1]);
            minDiff = Math.min(minDiff, tasks[i][1] - tasks[i][0]);
        }
        return Math.max(res + minDiff, max);
    }
}
