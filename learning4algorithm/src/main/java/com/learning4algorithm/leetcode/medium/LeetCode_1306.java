package com.learning4algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_1306 {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int length = arr.length;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (arr[index] == 0) {
                return true;
            }
            if (arr[index] < 0) {
                continue;
            }
            if (index + arr[index] < length) {
                queue.add(index + arr[index]);
            }
            if (index - arr[index] >= 0) {
                queue.add(index - arr[index]);
            }
            arr[index] = -arr[index];
        }
        return false;
    }
}
