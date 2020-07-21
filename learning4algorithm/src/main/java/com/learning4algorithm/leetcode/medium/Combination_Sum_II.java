package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, list, ret, candidates);
        return ret;
    }

    public void dfs(int position, int target, List<Integer> list, List<List<Integer>> ret, int[] candidates) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = position; i < candidates.length; i++) {
            if (i > position && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 添加
            list.add(candidates[i]);
            dfs(i + 1, target - candidates[i], list, ret, candidates);
            // 删除
            list.remove(list.size() - 1);
        }
    }
}
