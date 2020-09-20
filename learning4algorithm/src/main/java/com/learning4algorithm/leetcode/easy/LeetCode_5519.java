package com.learning4algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LeetCode_5519 {

    public String reorderSpaces(String text) {
        int spaceNum = 0;
        boolean isletter = false;
        int wordNum = 0;
        List<String> strList = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceNum++;
                if (isletter) {
                    strList.add(s.toString());
                    s = new StringBuilder();
                }
                isletter = false;
            } else {
                s.append(c);
            }
            if (c != ' ' && !isletter) {
                isletter = true;
                wordNum++;
            }
        }
        if (text.charAt(text.length() - 1) != ' ') {
            if (isletter) {
                strList.add(s.toString());
            }
        }
        if (wordNum == 1) {
            StringBuilder single = new StringBuilder();
            int blank = 0;
            for (char c : text.toCharArray()) {
                if (c != ' ') {
                    single.append(c);
                } else {
                    blank++;
                }
            }
            IntStream.range(0, blank).forEach(i -> single.append(" "));
            return single.toString();
        }
        int space = spaceNum / (wordNum - 1);
        int extra = spaceNum % (wordNum - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strList.size(); i++) {
            res.append(strList.get(i));
            if (i < strList.size() - 1) {
                IntStream.range(0, space).forEach(index -> res.append(" "));
            }
        }
        if (extra != 0) {
            IntStream.range(0, extra).forEach(i -> res.append(" "));
        }
        return res.toString();
    }
}
