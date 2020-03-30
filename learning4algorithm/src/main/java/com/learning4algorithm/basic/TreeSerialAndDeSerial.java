package com.learning4algorithm.basic;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialAndDeSerial {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node deserialByPre(String preStr) {
        String[] value = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : value) {
            queue.add(s);
        }
        return deserialByPre(queue);
    }

    public static Node deserialByPre(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = deserialByPre(queue);
        head.right = deserialByPre(queue);
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = null;
        node1.left.right = new Node(3);
        // System.out.println(serialByPre(node1));
        Node head = deserialByPre("1_2_#_3_#_#_#_");
        System.out.println(head.value);

    }
}
