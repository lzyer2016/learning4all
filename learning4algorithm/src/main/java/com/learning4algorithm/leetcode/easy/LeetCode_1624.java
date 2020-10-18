package com.learning4algorithm.leetcode.easy;

public class LeetCode_1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        if (s.length() <= 1) {
            return ans;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans = Math.max(ans, (i - j) - 1);
                }
            }
        }
        return ans;
    }
}
