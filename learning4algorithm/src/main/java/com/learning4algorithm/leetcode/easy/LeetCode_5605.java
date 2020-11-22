package com.learning4algorithm.leetcode.easy;

public class LeetCode_5605 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        //  Arrays.sort(word1);
        //  Arrays.sort(word2);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int i = 0;
        while (i < word1.length) {
            s1.append(word1[i++]);
        }
        i = 0;
        while (i < word2.length) {
            s2.append(word2[i++]);
        }
        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args) {
        LeetCode_5605 lc = new LeetCode_5605();
        String[] str1 = {"ab", "c"};
        String[] str2 = {"a", "bc"};
        System.out.println(lc.arrayStringsAreEqual(str1, str2));
    }
}
