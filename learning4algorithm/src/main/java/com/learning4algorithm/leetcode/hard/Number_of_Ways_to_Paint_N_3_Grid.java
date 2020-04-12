package com.learning4algorithm.leetcode.hard;

public class Number_of_Ways_to_Paint_N_3_Grid {

    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123, mod = (long) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int) ((a121 + a123) % mod);
    }
}
