package com.learning4algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

    int result = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        dfs(arr, "", 0);
        return result;
    }

    public void dfs(List<String> arr, String path, int cur) {
        boolean isUnique = isUniqueChar(path);
        if (isUnique) {
            result = Math.max(path.length(), result);
        }
        if (cur == arr.size() || !isUnique) {
            return;
        }
        for (int i = cur; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    public boolean isUniqueChar(String path) {
        Set<Character> set = new HashSet<>();
        for (char c : path.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
