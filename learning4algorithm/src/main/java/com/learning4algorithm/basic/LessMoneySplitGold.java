package com.learning4algorithm.basic;

import java.util.PriorityQueue;

/**
 * 切金条问题
 * (哈夫曼编码)
 */
public class LessMoneySplitGold {

    public int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int sum = 0;
        while (queue.size() > 1) {
            int cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
}
