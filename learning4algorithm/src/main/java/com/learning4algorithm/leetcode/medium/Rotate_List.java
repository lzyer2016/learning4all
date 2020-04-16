package com.learning4algorithm.leetcode.medium;

public class Rotate_List {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode p = head;

        int len = 0;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        int move = ((len - (k % len)) % len);
        if (move == 0 || (k == len)) {
            return head;
        }
        // head concat tail
        p.next = head;
        len++;
        while (move-- > 1) {
            head = head.next;
        }
        p = head.next;
        head.next = null;
        head = p;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        int k = 2;
        rotateRight(node1, k);
    }
}
