package com.learning4algorithm.leetcode.medium;

public class LeetCode_1702 {
    public String maximumBinaryString(String binary) {
        int k = 0;
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                k = i;
                break;
            }
        }
        for (int i = k + 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                count++;
            }
        }
        if (count == 0) return binary;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (i != (k + count)) {
                res.append("1");
            } else {
                res.append("0");
            }
        }
        return res.toString();
    }
}
