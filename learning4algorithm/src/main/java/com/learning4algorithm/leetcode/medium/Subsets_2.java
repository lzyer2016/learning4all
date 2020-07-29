package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        help(0, new ArrayList<>(), ret, nums);
        return ret;
    }

    public void help(int cur, List<Integer> step, List<List<Integer>> ret, int[] nums) {
        ret.add(new ArrayList<>(step));
        for (int i = cur; i < nums.length; i++) {
            if (i == cur || nums[i] != nums[i - 1]) {
                step.add(nums[i]);
                help(i + 1, step, ret, nums);
                step.remove(step.size() - 1);
            }
        }
    }
}
