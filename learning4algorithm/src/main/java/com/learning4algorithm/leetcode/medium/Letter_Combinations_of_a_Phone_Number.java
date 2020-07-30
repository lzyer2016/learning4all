package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return Arrays.asList(digits);
        }
        String[] letters = {"", "", "abc", "def", "ghi", "opq", "rst", "uvw", "xyz"};
        List<String> ret = new ArrayList<>();
        help(0, new StringBuilder(), letters, digits, ret);
        return ret;
    }

    public void help(int cur, StringBuilder step, String[] letters, String digits, List<String> ret) {
        if (cur == digits.length()) {
            ret.add(step.toString());
            return;
        }
        for (char c : letters[digits.charAt(cur) - '0'].toCharArray()) {
            step.append(c);
            help(cur + 1, step, letters, digits, ret);
            step.deleteCharAt(step.length() - 1);
        }
    }
}
