package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class LeetCode_1319 {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            if (Objects.isNull(map.get(connections[i][0]))) {
                map.put(connections[i][0], new ArrayList<>());
            }
            map.get(connections[i][0]).add(connections[i][1]);
            if (Objects.isNull(map.get(connections[i][1]))) {
                map.put(connections[i][1], new ArrayList<>());
            }
            map.get(connections[i][1]).add(connections[i][0]);
        }
        int[] seen = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(i, map, seen);
        }
        return ans - 1;
    }

    public int dfs(int cur, Map<Integer, List<Integer>> map, int[] seen) {
        if (seen[cur] == 1) {
            return 0;
        }
        seen[cur] = 1;
        List<Integer> dist = map.get(cur);
        if (dist != null && dist.size() > 0) {
            for (int o : dist) {
                dfs(o, map, seen);
            }
        }
        return 1;
    }
}
