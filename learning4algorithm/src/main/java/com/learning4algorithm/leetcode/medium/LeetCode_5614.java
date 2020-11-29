package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_5614 {

    public int[] mostCompetitive(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && list.get(list.size() - 1) > nums[i] && list.size() - 1 + nums.length - i >= k) {
                list.remove(list.size() - 1);
            }
            if (list.size() < k) {
                list.add(nums[i]);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
