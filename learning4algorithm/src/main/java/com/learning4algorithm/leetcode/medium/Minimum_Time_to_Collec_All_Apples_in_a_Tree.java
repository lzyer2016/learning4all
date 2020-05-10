package com.learning4algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Minimum_Time_to_Collec_All_Apples_in_a_Tree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Integer> edgeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            edgeMap.put(edges[i][1], edges[i][0]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < hasApple.size(); i++) {
            if (Boolean.TRUE.equals(hasApple.get(i))) {
                set.add(i);
                int parent = 0;
                int current = i;
                while (current != parent) {
                    current = edgeMap.get(current);
                    set.add(current);
                }
            }
        }
        if (set.size() > 0) {
            return (set.size() - 1) * 2;
        }
        return 0;
    }
}
