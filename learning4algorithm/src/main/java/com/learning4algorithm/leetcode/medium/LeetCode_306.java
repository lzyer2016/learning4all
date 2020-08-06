package com.learning4algorithm.leetcode.medium;

public class LeetCode_306 {

    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        for (int i = 1; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                long a = parseLong(num.substring(0, i));
                long b = parseLong(num.substring(i, j));
                if (a == -1 || b == -1) {
                    continue;
                }
                if (dfs(num.substring(j), a, b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(String s, long a, long b) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            long c = parseLong(s.substring(0, i));
            if (c == -1)
                continue;
            if (a + b == c && dfs(s.substring(i), b, c)) {
                return true;
            }
        }
        return false;
    }

    public long parseLong(String s) {
        if (!s.equals("0") && s.startsWith("0")) {
            return -1;
        }
        long num;
        try {
            num = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
        return num;
    }
}
