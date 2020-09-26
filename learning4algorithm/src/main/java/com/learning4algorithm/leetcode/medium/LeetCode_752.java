package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class LeetCode_752 {

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (target == null || target.length() == 0) {
            return -1;
        }
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (!visit.add(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return ans;
                }
                for (String lock : getNextLock(cur)) {
                    if (!visit.contains(lock)) {
                        queue.add(lock);
                    }
                }
            }

            ans++;
        }
        return -1;
    }

    public List<String> getNextLock(String cur) {
        char[] locks = cur.toCharArray();
        List<String> lockList = new ArrayList<>();
        for (int i = 0; i < locks.length; i++) {
            char c = locks[i];
            locks[i] = c == '9' ? '0' : (char) (c + 1);
            lockList.add(new String(locks));
            locks[i] = c == '0' ? '9' : (char) (c - 1);
            lockList.add(new String(locks));
            locks[i] = c;
        }
        return lockList;
    }
}
