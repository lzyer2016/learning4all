package com.learning4algorithm.leetcode.medium;

import java.util.Stack;

public class Add_Two_Numbers_II {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p1 = l1;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        ListNode p2 = l2;
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        ListNode head = new ListNode(-1);
        int c = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + c;
            c = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = head.next;
            head.next = node;
        }

        while (!s1.isEmpty()) {
            int sum = s1.pop() + c;
            c = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = head.next;
            head.next = node;
        }
        while (!s2.isEmpty()) {
            int sum = s2.pop() + c;
            c = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = head.next;
            head.next = node;
        }
        if (c > 0) {
            ListNode node = new ListNode(c);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
}
