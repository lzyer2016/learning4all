package com.learning4algorithm.leetcode.medium;

import javafx.beans.binding.When;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_5520 {

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(set, 0, s);
    }

    public int dfs(Set<String> set, int step, String s) {
        if (step >= s.length()) {
            return 0;
        }
        int res = -1;
        for (int i = step + 1; i <= s.length(); i++) {
            String sub = s.substring(step, i);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            int next = dfs(set, i, s);
            if (next >= 0) {
                res = Math.max(res, next + 1);
            }
            set.remove(sub);
        }
        return res;
    }
}
