package com.learning4algorithm.leetcode.medium;

public class Beautiful_Arrangement526 {

    private int count = 0;

    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        helper(N, N, new boolean[N + 1]);
        return count;
    }

    public void helper(int N, int k, boolean[] visit) {
        if (k == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i] || k % i != 0 && i % k != 0) {
                continue;
            }
            visit[i] = true;
            helper(N, k - 1, visit);
            visit[i] = false;
        }
    }
}
