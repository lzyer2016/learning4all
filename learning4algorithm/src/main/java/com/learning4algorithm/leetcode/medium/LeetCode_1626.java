package com.learning4algorithm.leetcode.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < ages.length; i++) {
            Pair<Integer, Integer> pair = new Pair<>(ages[i], scores[i]);
            pairList.add(pair);
        }
        pairList.sort((a, b) -> {
            if (a.getKey().compareTo(b.getKey()) == 0) {
                return a.getValue().compareTo(b.getValue());
            }
            return a.getKey().compareTo(b.getKey());
        });
        int n = ages.length;
        int[] f = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            f[i] = pairList.get(i).getValue();
            for (int j = 0; j < i; j++) {
                if (pairList.get(i).getValue() >= pairList.get(j).getValue()) {
                    f[i] = Math.max(f[i], f[j] + pairList.get(i).getValue());
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
