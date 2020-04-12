package com.learning4algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class String_Matching_In_An_Array {

    public List<String> stringMatching(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        Set<String> set = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    set.add(words[i]);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
