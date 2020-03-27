package com.learning4algorithm.leetcode.easy;

public class Solution1374 {

    public String generateTheString(int n) {
        char a = 'a';
        char b = 'b';
        StringBuilder str = new StringBuilder();
        if ((n & 1) == 1) {
            for (int i = 0; i < n; i++) {
                str.append(a);
            }
        } else {
            str.append(a);
            for (int i = 1; i < n; i++) {
                str.append(b);
            }
        }
        return str.toString();
    }
}
