package com.learning4algorithm.basic;

/**
 * 查找最低公共祖先节点
 */
public class FindCommonNode {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        boolean findN1;
        boolean findN2;
        Node ans;

        Info(boolean n1, boolean n2, Node ans) {
            this.findN1 = n1;
            this.findN2 = n2;
            this.ans = ans;
        }
    }

    public Info process(Node x, Node o1, Node o2) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, o1, o2);
        Info rightInfo = process(x.right, o1, o2);
        if (leftInfo.ans != null) {
            return new Info(true, true, leftInfo.ans);
        }
        if (rightInfo.ans != null) {
            return new Info(true, true, rightInfo.ans);
        }
        if (leftInfo.findN1 && rightInfo.findN2) {
            return new Info(true, true, x);
        }
        if (leftInfo.findN2 && rightInfo.findN1) {
            return new Info(true, true, x);
        }

        boolean findN1 = x == o1;
        boolean findN2 = x == o2;
        if (leftInfo.findN1 || rightInfo.findN1) {
            if (findN2) {
                return new Info(true, true, x);
            } else {
                return new Info(true, false, null);
            }
        }

        if (leftInfo.findN2 || rightInfo.findN2) {
            if (findN1) {
                return new Info(true, true, x);
            } else {
                return new Info(false, false, null);
            }
        }
        return new Info(findN1, findN2, null);
    }
}
