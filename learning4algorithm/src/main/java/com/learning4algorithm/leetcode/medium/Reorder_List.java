package com.learning4algorithm.leetcode.medium;

public class Reorder_List {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode midHead = new ListNode(-1);
        ListNode p = mid;
        while (p != null) {
            ListNode tail = midHead.next;
            midHead.next = p;
            ListNode next = p.next;
            p.next = tail;
            p = next;
        }

        ListNode left = head;
        ListNode right = midHead.next;
        while (right.next != null) {
            ListNode l = left.next;
            left.next = right;
            ListNode r = right.next;
            right.next = l;
            left = l;
            right = r;
        }

    }


    public static void backList(ListNode head) {
        ListNode preHead = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode tail = preHead.next;
            preHead.next = p;
            ListNode next = p.next;
            p.next = tail;
            p = next;
        }
    }

    public static void main(String[] args) {
        // [1,2,3,4]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        /*ListNode node5 = new ListNode(5);
        node4.next = node5;*/
        reorderList(node1);
        //backList(node1);
    }

}
