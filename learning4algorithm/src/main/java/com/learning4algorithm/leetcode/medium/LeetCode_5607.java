package com.learning4algorithm.leetcode.medium;

public class LeetCode_5607 {

    public int waysToMakeFair(int[] nums) {
        int res = 0, len = nums.length;
        int[] even = new int[len + 1];
        int[] odd = new int[len + 1];
        int j = 1;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 1) {
                odd[j] += odd[j - 1] + nums[i];
                even[j] = even[j - 1];
            } else {
                even[j] += even[j - 1] + nums[i];
                odd[j] = odd[j - 1];
            }
            j++;
        }
        for (int i = 1; i <= len; i++) {
            int s = 0, s2 = 0;
            s = odd[i - 1] + even[len] - even[i];
            s2 = even[i - 1] + odd[len] - odd[i];
            if (s == s2) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_5607 lc = new LeetCode_5607();
        int[] nums = {2, 1, 6, 4};
        System.out.println(lc.waysToMakeFair(nums));
    }
}
