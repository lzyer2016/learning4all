package com.learning4algorithm.basic;

/**
 * 查找节点的前继节点
 */
public class FindPreCursurNode {

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
        }
    }

    Node findPreCursurNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return getMostRight(node.left);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    Node getMostRight(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
