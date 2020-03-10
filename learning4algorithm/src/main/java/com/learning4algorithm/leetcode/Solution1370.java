package com.learning4algorithm.leetcode;

public class Solution1370 {

    public String sortString(String s) {
        int[] words = new int[26];
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        while (result.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (words[i] != 0) {
                    result.append((char) ('a' + i));
                    words[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (words[i] != 0) {
                    result.append((char) ('a' + i));
                    words[i]--;
                }
            }
        }
        return result.toString();
    }
}
