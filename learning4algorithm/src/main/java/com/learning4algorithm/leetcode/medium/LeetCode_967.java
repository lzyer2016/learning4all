package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_967 {

    public int[] numsSameConsecDiff(int n, int k) {
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (n == 1) {
            return num;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n - 1, i, k, result);
        }
        return result.stream().mapToInt(t -> t).toArray();
    }

    public void dfs(int N, int num, int k, List<Integer> result) {
        if (N == 0) {
            result.add(num);
            return;
        }
        List<Integer> ans = new ArrayList<>();
        int tail = num % 10;
        ans.add(tail + k);
        if (k != 0) {
            ans.add(tail - k);
        }
        for (Integer digit : ans) {
            if (0 <= digit && digit < 10) {
                int newNum = num * 10 + digit;
                dfs(N - 1, newNum, k, result);
            }
        }
    }
}
