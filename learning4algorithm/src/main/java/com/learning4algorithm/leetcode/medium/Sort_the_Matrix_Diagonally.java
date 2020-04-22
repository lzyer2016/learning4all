package com.learning4algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_the_Matrix_Diagonally {

    public int[][] diagonalSort(int[][] mat) {
        if (mat == null) {
            return null;
        }
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent((i - j), new PriorityQueue<>());
                map.get((i - j)).add(mat[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }
}
