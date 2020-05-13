package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            } else {
                ret.add(Math.abs(nums[i]));
            }
        }
        return ret;
    }
}
