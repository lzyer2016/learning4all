package com.learning4algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 1337. The K Weakest Rows in a Matrix
 */
public class Solution1337 {

    class Node {
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Node[] nodes = new Node[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int value = 0;
            for (int j = 0; j < mat[i].length; j++) {
                value += mat[i][j];
            }
            nodes[i] = new Node(i, value);
        }
        Arrays.sort(nodes, (a, b) -> {
            if (a.value > b.value) {
                return -1;
            }
            if (a.value < b.value) {
                return 1;
            }
            if (a.value == b.value) {
                return b.index - a.index;
            }
            return 0;
        });
        int[] ret = new int[k];
        for (int i = 0, j = nodes.length - 1; i < k; i++) {
            ret[i] = nodes[j--].index;
        }
        return ret;
    }
}
