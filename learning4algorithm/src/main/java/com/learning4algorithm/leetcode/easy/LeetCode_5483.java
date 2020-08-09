package com.learning4algorithm.leetcode.easy;

public class LeetCode_5483 {

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        int start = 0;
        while (sb.length() != 0 && start < sb.length() - 1) {
            for (int i = 0; i < sb.length() - 1; i++, start++) {
                if ((sb.charAt(i) - 32) == sb.charAt(i + 1) || sb.charAt(i) == (sb.charAt(i + 1) - 32)) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    start = 0;
                    break;
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
}
