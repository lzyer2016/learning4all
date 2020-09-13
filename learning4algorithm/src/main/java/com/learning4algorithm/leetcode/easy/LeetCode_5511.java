package com.learning4algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_5511 {

    public int numSpecial(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> columnMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                    columnMap.put(j, columnMap.getOrDefault(j, 0) + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rowMap.get(i) == 1 && columnMap.get(j) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
