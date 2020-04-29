package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 */
public class Lexicographical {

    private List<String> result = new ArrayList<>();

    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        rec(n - 1, sb);
        sb.setLength(sb.length() - 1);

        sb.append('b');
        rec(n - 1, sb);
        sb.setLength(sb.length() - 1);

        sb.append('c');
        rec(n - 1, sb);
        sb.setLength(sb.length() - 1);
        return k > result.size() ? "" : result.get(k - 1);
    }


    public void rec(int n, StringBuilder sb) {
        if (n == 0) {
            result.add(sb.toString());
            return;
        }
        char c = sb.charAt(sb.length() - 1);

        if (c == 'a') {
            sb.append('b');
            rec(n - 1, sb);
            sb.setLength(sb.length() - 1);
            sb.append('c');
            rec(n - 1, sb);
            sb.setLength(sb.length() - 1);
        }
        if (c == 'b') {
            sb.append('a');
            rec(n - 1, sb);
            sb.setLength(sb.length() - 1);
            sb.append('c');
            rec(n - 1, sb);
            sb.setLength(sb.length() - 1);
        }
        if (c == 'c') {
            sb.append('a');
            rec(n - 1, sb);
            sb.setLength(sb.length() - 1);
            sb.append('b');
            rec(n - 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
