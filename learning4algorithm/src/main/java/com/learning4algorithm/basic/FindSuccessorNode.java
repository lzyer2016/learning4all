package com.learning4algorithm.basic;

/**
 * 查找节点的后继节点
 */
public class FindSuccessorNode {

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
        }
    }

    Node findSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getMostLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    Node getMostLeft(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
