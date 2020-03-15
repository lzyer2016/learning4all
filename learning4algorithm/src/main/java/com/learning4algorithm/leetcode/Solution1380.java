package com.learning4algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. Lucky Numbers in a Matrix
 */
public class Solution1380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = 100001;
            int y = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    y = j;
                }
            }
            int max = -1;
            for (int k = 0; k < matrix.length; k++) {
                if (max < matrix[k][y]) {
                    max = matrix[k][y];
                }
            }
            if (max == min) {
                ret.add(max);
            }
        }
        return ret;
    }
}
