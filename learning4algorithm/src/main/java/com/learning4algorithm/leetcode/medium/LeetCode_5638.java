package com.learning4algorithm.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_5638 {

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int res = 0;
        int n = apples.length;
        for (int i = 0; i <= 40000; i++) {
            if (i < n && apples[i] > 0) {
                pq.add(new int[]{i + days[i] - 1, apples[i]});
            }
            while (!pq.isEmpty() && pq.peek()[0] < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res++;
                int[] cur = pq.poll();
                cur[1]--;
                if (cur[1] > 0) {
                    pq.add(cur);
                }
            }
        }
        return res;
    }
}
