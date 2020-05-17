package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class People_Whose_List_of_Favorite_Companies {

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> pos = new ArrayList<>();
        int len = favoriteCompanies.size();
        for (int i = 0; i < len; i++) {
            List<String> strList = favoriteCompanies.get(i);
            for (int j = 0; j < len; j++) {
                List<String> str2 = favoriteCompanies.get(j);
                if (i != j && str2.size() > strList.size() && str2.containsAll(strList)) {
                    pos.add(i);
                    break;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            if (!pos.contains(i)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("nxaqhyoprhlhvhyojanr", "ovqdyfqmlpxapbjwtssm", "qmsbphxzmnvflrwyvxlc", "udfuxjdxkxwqnqvgjjsp", "yawoixzhsdkaaauramvg", "zycidpyopumzgdpamnty");
        List<String> l2 = Arrays.asList("nxaqhyoprhlhvhyojanr", "ovqdyfqmlpxapbjwtssm", "udfuxjdxkxwqnqvgjjsp", "yawoixzhsdkaaauramvg", "zycidpyopumzgdpamnty");
        List<String> l3 = Arrays.asList("ovqdyfqmlpxapbjwtssm", "qmsbphxzmnvflrwyvxlc", "udfuxjdxkxwqnqvgjjsp", "yawoixzhsdkaaauramvg", "zycidpyopumzgdpamnty");
        List<List<String>> list = Arrays.asList(l1, l2, l3);
        System.out.println(peopleIndexes(list));
    }
}
