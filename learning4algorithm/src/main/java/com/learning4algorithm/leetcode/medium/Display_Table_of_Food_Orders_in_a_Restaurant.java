package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [
 * ["David","3","Ceviche"],
 * ["Corina","10","Beef Burrito"],
 * ["David","3","Fried Chicken"],
 * ["Carla","5","Water"],
 * ["Carla","5","Ceviche"],
 * ["Rous","3","Ceviche"]
 * ]
 * <p>
 * <p>
 * [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],
 * ["3","0","2","1","0"],
 * ["5","0","1","0","1"],
 * ["10","1","0","0","0"]]
 */
public class Display_Table_of_Food_Orders_in_a_Restaurant {

    public List<List<String>> displayTable(List<List<String>> orders) {
        if (orders == null) {
            return null;
        }
        List<String> enums = new ArrayList<>();
        List<String> table = new ArrayList<>();
        Map<String, List<String>> tableMap = new HashMap<>();
        for (List<String> order : orders) {
            if (tableMap.containsKey(order.get(1))) {
                tableMap.get(order.get(1)).add(order.get(2));
            } else {
                List<String> list = new ArrayList<>();
                list.add(order.get(2));
                tableMap.put(order.get(1), list);
            }
            table.add(order.get(1));
            enums.add(order.get(2));
        }
        enums = enums.stream().distinct().sorted().collect(Collectors.toList());
        table = table.stream().distinct().sorted(Comparator.comparing(Integer::valueOf)).collect(Collectors.toList());
        List<List<String>> ret = new ArrayList<>();
        List<String> tableTitle = new ArrayList<>();
        tableTitle.add("Table");
        tableTitle.addAll(enums);
        ret.add(tableTitle);
        for (String row : table) {
            List<String> enumeList = tableMap.get(row);
            List<String> tableContent = new ArrayList<>();
            tableContent.add(row);
            for (String e : enums) {
                int count = 0;
                for (String el : enumeList) {
                    if (e.equals(el)) {
                        count++;
                    }
                }
                tableContent.add(String.valueOf(count));
            }
            ret.add(tableContent);
        }
        return ret;
    }
}
