package com.learning4algorithm.leetcode.medium;

public class Queries_on_a_Permutation_With_Key {

    public int[] processQueries(int[] queries, int m) {
        int[] ret = new int[queries.length];
        int[] p = new int[m];
        for (int i = 1; i <= m; i++) {
            p[i - 1] = i;
        }
        int index = 0;
        for (int k = 0; k < queries.length; k++) {
            int position = search(p, queries[k]);
            ret[index++] = position;
            move(p, position);
        }
        return ret;
    }

    public void move(int[] p, int position) {
        int temp = p[position];
        while (position > 0) {
            p[position] = p[position - 1];
            position--;
        }
        p[0] = temp;
    }

    public int search(int[] p, int query) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == query) {
                return i;
            }
        }
        return -1;
    }
}
