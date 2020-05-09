package com.learning4algorithm.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reduce_Array_Size_to_The_Half {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry.getValue());
        }
        int length = arr.length;
        int half = length / 2;
        int size = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            length -= n;
            size++;
            if (length <= half) {
                break;
            }
        }
        return size;
    }
}
