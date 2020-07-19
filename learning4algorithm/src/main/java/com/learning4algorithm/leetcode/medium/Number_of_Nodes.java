package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class Number_of_Nodes {

    public int[] countSubTrees(int n, int[][] edges, String labels) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int[] ret = new int[n];
        dfs(map, 0, ret, visited, labels);
        return ret;
    }

    public int[] dfs(Map<Integer, List<Integer>> map, int position, int[] ret, Set<Integer> visited, String labels) {
        int[] cnt = new int[26];
        if (visited.add(position)) {
            char c = labels.charAt(position);
            for (int next : map.getOrDefault(position, Collections.emptyList())) {
                int[] sub = dfs(map, next, ret, visited, labels);
                for (int i = 0; i < cnt.length; i++) {
                    cnt[i] += sub[i];
                }
            }
            cnt[c - 'a']++;
            ret[position] = cnt[c - 'a'];
        }
        return ret;
    }
}
