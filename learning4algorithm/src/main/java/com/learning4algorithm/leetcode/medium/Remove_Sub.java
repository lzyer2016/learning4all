package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Remove_Sub {

    public List<String> removeSubfolders(String[] folder) {
        if (folder == null || folder.length == 0) {
            return null;
        }
        Arrays.sort(folder, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compare = o1.compareTo(o2);
                if (compare != 0) {
                    return Integer.compare(o1.length(), o2.length());
                } else {
                    return compare;
                }
            }
        });
        List<String> list = new ArrayList<>();
        for (String f : folder) {
            if (!list.isEmpty()) {
                boolean flag = true;
                for (String str : list) {
                    if (f.startsWith(str + "/")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(f);
                }
            } else {
                list.add(f);
            }
        }
        return list;
    }
}
