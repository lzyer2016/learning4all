package com.learning4algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node pNode = map.get(p);
            pNode.next = map.get(p.next);
            pNode.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
