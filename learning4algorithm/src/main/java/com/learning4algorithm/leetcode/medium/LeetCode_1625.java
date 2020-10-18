package com.learning4algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode_1625 {

    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> seen = new HashSet<>(queue);
        int n = s.length();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }
            char[] chars = cur.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String addA = new String(chars);
            if (seen.add(addA)) {
                queue.add(addA);
            }
            String rotateA = cur.substring(n - b) + cur.substring(0, n - b);
            if (seen.add(rotateA)) {
                queue.add(rotateA);
            }
        }
        return smallest;
    }
}
