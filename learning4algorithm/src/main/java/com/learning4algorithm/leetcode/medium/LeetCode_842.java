package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_842 {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<>();
        helper(0, ret, S);
        return ret;
    }

    public boolean helper(int cur, List<Integer> ret, String S) {
        if (cur == S.length() && ret.size() >= 3) {
            return true;
        }
        for (int i = cur; i < S.length(); i++) {
            if (S.charAt(cur) == '0' && i > cur) {
                break;
            }
            long num = Long.parseLong(S.substring(cur, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = ret.size();
            if (size >= 2 && num > ret.get(size - 1) + ret.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == ret.get(size - 1) + ret.get(size - 2)) {
                ret.add((int) num);
                if (helper(i + 1, ret, S)) {
                    return true;
                }
                ret.remove(ret.size() - 1);
            }
        }
        return false;
    }
}
