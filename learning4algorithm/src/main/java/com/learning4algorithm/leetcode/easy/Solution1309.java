package com.learning4algorithm.leetcode.easy;

/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 */
public class Solution1309 {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) (Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1)) - 1 + 'a'));
                i += 2;
            } else {
                sb.append((char) (Integer.parseInt(s.charAt(i) + "") - 1 + 'a'));
            }
        }
        return sb.toString();
    }
}
