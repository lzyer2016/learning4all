package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_784 {

    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        help(0, S.toCharArray(), ret);
        return ret;
    }

    public void help(int pos, char[] str, List<String> ret) {
        if (pos == str.length) {
            ret.add(new String(str));
            return;
        }
        if (str[pos] >= '0' && str[pos] <= '9') {
            help(pos + 1, str, ret);
            return;
        }
        str[pos] = Character.toUpperCase(str[pos]);
        help(pos + 1, str, ret);
        str[pos] = Character.toLowerCase(str[pos]);
        help(pos + 1, str, ret);
    }
}
