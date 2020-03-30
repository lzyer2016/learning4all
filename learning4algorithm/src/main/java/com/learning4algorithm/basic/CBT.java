package com.learning4algorithm.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树
 */
public class CBT {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean isCBT(Node head) {
        Queue<Node> queue = new LinkedList<>();
        Node l = null;
        Node r = null;
        boolean isMeet = false;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            l = node.left;
            r = node.right;
            if ((isMeet && (l != null || r != null)) ||
                    (l == null && r != null)) {
                return false;
            }

            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }

            if (l == null || r == null) {
                isMeet = true;
            }
        }
        return true;
    }
}
