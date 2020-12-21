package com.learning4algorithm.leetcode.medium;

public class LeetCode_5630 {
    public static int maximumUniqueSubarray(int[] nums) {
        int[] q = new int[100005];
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            q[nums[i]]++;
            while (q[nums[i]] > 1) {
                q[nums[j]]--;
                j++;
            }
            res = Math.max(sum[i + 1] - sum[j], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(maximumUniqueSubarray(arr));
    }
}
