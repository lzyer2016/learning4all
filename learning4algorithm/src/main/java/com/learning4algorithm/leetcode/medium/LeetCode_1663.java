package com.learning4algorithm.leetcode.medium;

import java.util.Arrays;

public class LeetCode_1663 {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        int i = n - 1;
        while (k > 0) {
            int tmp = Math.min(k, 25);
            res[i] += tmp;
            k -= tmp;
            i--;
        }
        return new String(res);
    }
}
