package com.learning4algorithm.leetcode.medium;

public class Array_Nesting {

    public int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int ak = nums[k];
                nums[k] = -1;
                k = ak;
            }
            ans = Math.max(size, ans);
        }
        return ans;
    }
}
