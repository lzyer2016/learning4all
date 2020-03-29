package com.learning4algorithm.basic;

/**
 * 判断二叉树是否为满二叉树
 */
public class FullTreeTest {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        int nodes;
        int height;

        Info(int nodes, int height) {
            this.nodes = nodes;
            this.height = height;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(nodes, height);
    }

    static boolean isFull(Node head) {
        Info info = process(head);
        // nodes = 2^H - 1
        return info.nodes == ((1 << info.height) - 1);
    }
}
