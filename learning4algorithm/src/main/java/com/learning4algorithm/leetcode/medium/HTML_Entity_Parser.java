package com.learning4algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class HTML_Entity_Parser {

    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        for (String key : map.keySet()) {
            if (text.contains(key)) {
                text = text.replaceAll(key, map.get(key));
            }
        }
        return text;
    }
}
