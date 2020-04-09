package com.learning4algorithm.leetcode.medium;

public class Flatten_A_Multilevel_Doubly_Linked_List {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node line = p.child;
            while (line.next != null) {
                line = line.next;
            }
            line.next = p.next;
            if (p.next != null) {
                p.next.prev = line;
            }
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
