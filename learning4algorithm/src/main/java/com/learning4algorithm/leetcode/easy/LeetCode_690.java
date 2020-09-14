package com.learning4algorithm.leetcode.easy;

import java.util.*;

public class LeetCode_690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> queue = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        queue.add(map.get(id));
        int ans = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            ans += employee.importance;
            for (Integer index : employee.subordinates) {
                queue.add(map.get(index));
            }
        }
        return ans;
    }
}
