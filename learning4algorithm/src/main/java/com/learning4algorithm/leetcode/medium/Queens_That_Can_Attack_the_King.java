package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queens_That_Can_Attack_the_King {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < queens.length; i++) {
            set.add(queens[i][0] + ":" + queens[i][1]);
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = 1; k <= 8; k++) {
                    int x = king[0] + i * k;
                    int y = king[1] + j * k;
                    if (set.contains(x + ":" + y)) {
                        ret.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return ret;
    }
}
