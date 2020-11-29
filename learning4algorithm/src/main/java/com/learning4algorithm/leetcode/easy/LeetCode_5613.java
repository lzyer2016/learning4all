package com.learning4algorithm.leetcode.easy;

public class LeetCode_5613 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        if (accounts == null || accounts.length == 0) {
            return max;
        }
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
