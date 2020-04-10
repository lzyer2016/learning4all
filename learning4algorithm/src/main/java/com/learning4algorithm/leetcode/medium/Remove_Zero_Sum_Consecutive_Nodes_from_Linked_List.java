package com.learning4algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> prefixSum = new HashMap<>();
        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        int sum = 0;
        while (p != null) {
            sum += p.val;
            prefixSum.put(sum, p);
            p = p.next;
        }
        ListNode node = preHead;
        sum = 0;
        while (node != null) {
            sum += node.val;
            node.next = prefixSum.get(sum).next;
        }
        return preHead.next;
    }
}
