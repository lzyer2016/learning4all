package com.learning4algorithm.leetcode.medium;

public class Flip_String_to_Monotone_Increasing {

    public static int minFlipsMonoIncr(String S) {
        int length = S.length();
        int[] f0 = new int[length + 1];
        int[] f1 = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            f0[i] = f0[i - 1] + (S.charAt(i - 1) == '0' ? 0 : 1);
        }
        for (int i = length - 1; i >= 0; i--) {
            f1[i] = f1[i + 1] + (S.charAt(i) == '1' ? 0 : 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= length; i++) {
            ans = Math.min(ans, f0[i] + f1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
    }
}
