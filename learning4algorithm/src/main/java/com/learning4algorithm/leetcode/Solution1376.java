package com.learning4algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1376. Time Needed to Inform All Employees
 */
public class Solution1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            adj.putIfAbsent(manager[i], new ArrayList<>());
            adj.get(manager[i]).add(i);
        }
        int[] times = new int[n];
        times[headID] = informTime[headID];
        Queue<Integer> queue = new LinkedList<>();
        int maxTime = times[headID];
        queue.add(headID);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (adj.containsKey(curr)) {
                List<Integer> targets = adj.get(curr);
                for (int target : targets) {
                    times[target] = times[curr] + informTime[target];
                    if (times[target] > maxTime) {
                        maxTime = times[target];
                    }
                    queue.add(target);
                }
            }

        }
        return maxTime;
    }
}
