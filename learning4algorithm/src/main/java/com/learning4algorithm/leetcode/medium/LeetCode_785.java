package com.learning4algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_785 {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }
            colors[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[cur];
                        queue.add(next);
                    } else if (colors[cur] != -colors[next]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
