package com.learning4algorithm.leetcode.medium;

public class Subarray_Product_Less_Than_K {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int ans = 0;
        int left = 0;
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
