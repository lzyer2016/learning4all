package com.learning4algorithm.leetcode.medium;

import com.learning4algorithm.leetcode.easy.LeetCode_5561;

import java.util.*;

public class LeetCode_5562 {

    public int minDeletions(String s) {
        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (dict[i] > 0) {
                list.add(dict[i]);
            }
        }
        Collections.sort(list);
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                int val = list.get(i);
                val--;
                while (list.contains(val) && val > 0) {
                    val--;
                }
                list.set(i - 1, val);
                ans += (list.get(i) - val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_5562 lc = new LeetCode_5562();
        System.out.println(lc.minDeletions("abcabc"));
    }
}
