package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        if (nums == null) {
            return new ArrayList<>(ret);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int len = nums.length - 1;
            while (j < len) {
                int sum = nums[i] + nums[j] + nums[len];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j++], nums[len--]);
                    ret.add(list);
                } else if (sum > 0) {
                    len--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(ret);
    }
}
