package com.learning4algorithm.leetcode.medium;

import java.util.*;

public class Rank_Teams_by_Votes {

    public static String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) {
            return null;
        }
        Map<Character, int[]> map = new HashMap<>();
        int length = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[length]);
                map.get(c)[i]++;
            }
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < length; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : list) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
