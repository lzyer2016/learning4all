package com.learning4algorithm.leetcode.easy;

/**
 * 1323. Maximum 69 Number
 */
public class Solution1323 {

    public int maximum69Number(int num) {
        int[] bits = bitOne(num);
        for (int i = 3; i >= 0; i--) {
            if (bits[i] == 6) {
                bits[i] = 9;
                break;
            }
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            ret += (bits[i] * (int) Math.pow(10, i));
        }
        return ret;
    }

    public int[] bitOne(int num) {
        int[] bits = new int[4];
        int position = 0;
        while (num != 0) {
            int bit = num % 10;
            bits[position++] = bit;
            num /= 10;
        }
        return bits;
    }
}

