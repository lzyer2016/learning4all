package com.learning4algorithm.leetcode.easy;

public class Reformat_The_String {

    public String reformat(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String letter = "";
        String digit = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                letter += s.charAt(i);
            } else {
                digit += s.charAt(i);
            }
        }
        if (letter.length() == 0 || digit.length() == 0 || Math.abs(letter.length() - digit.length()) > 1) {
            return "";
        }
        String ret = "";
        if (letter.length() > digit.length()) {
            for (int i = 0; i < digit.length(); i++) {
                ret += letter.charAt(i);
                ret += digit.charAt(i);
            }
            ret += letter.charAt(letter.length() - 1);
        } else {
            for (int i = 0; i < letter.length(); i++) {
                ret += digit.charAt(i);
                ret += letter.charAt(i);
            }
            if (digit.length() != letter.length()) {
                ret += digit.charAt(digit.length() - 1);
            }
        }
        return ret;
    }
}
