package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return ret;
        }
        StringBuilder step = new StringBuilder();
        help(s, step, ret, 0, 0);
        return ret;
    }

    public void help(String s, StringBuilder step, List<String> ret, int start, int count) {
        if (start == s.length() && count == 3) {
            ret.add(step.toString());
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if (temp.length() > 3 || temp.length() > 1 && temp.charAt(0) == '0' || Integer.parseInt(temp) > 255) {
                continue;
            }
            StringBuilder newBuilder = new StringBuilder(step);
            if (newBuilder.length() != 0) {
                newBuilder.append(".");
            }
            newBuilder.append(temp);
            help(s, newBuilder, ret, i, newBuilder.length() == temp.length() ? count : count + 1);
        }
    }
}
