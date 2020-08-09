package com.learning4algorithm.leetcode.medium;

public class LeetCode_5484 {

    public static char findKthBit(int n, int k) {
        String str = "0";
        for (int i = 2; i <= n; i++) {
            String temp = str;
            if (str.length() > k) {
                return str.charAt(k - 1);
            }
            str = str + "1" + help(temp);
        }
        return str.charAt(k - 1);
    }

    public static StringBuilder help(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '0' ? "1" : "0");
        }
        sb.reverse();
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }
}
