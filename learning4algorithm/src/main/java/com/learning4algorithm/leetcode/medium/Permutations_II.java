package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        help(nums, new ArrayList<>(), visit, ret);
        return ret;
    }

    public void help(int[] nums, List<Integer> step, boolean[] visit, List<List<Integer>> ret) {
        if (step.size() == nums.length) {
            ret.add(new ArrayList<>(step));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !visit[i - 1]) {
                continue;
            }
            visit[i] = true;
            step.add(nums[i]);
            help(nums, step, visit, ret);
            visit[i] = false;
            step.remove(step.size() - 1);
        }
    }
}
