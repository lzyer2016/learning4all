package com.learning4algorithm.leetcode.medium;

import java.util.Arrays;

public class LeetCode_743 {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        for (int i = 0; i < N; i++) {
            for (int[] time : times) {
                int s = time[0];
                int e = time[1];
                int d = time[2];
                if (dist[s] != Integer.MAX_VALUE && dist[e] > dist[s] + d) {
                    dist[e] = dist[s] + d;
                }
            }
        }
        int maxWait = 0;
        for (int i = 1; i <= N; i++) {
            maxWait = Math.max(maxWait, dist[i]);
        }
        return maxWait == Integer.MAX_VALUE ? -1 : maxWait;
    }
}
