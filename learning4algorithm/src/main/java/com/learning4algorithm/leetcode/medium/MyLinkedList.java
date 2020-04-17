package com.learning4algorithm.leetcode.medium;

class MyLinkedList {

    class Node {
        public int val;

        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public int size;

    public Node head;

    /**
     * Initialize your data structure here.
     */

    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        if (size == 1) {
            return head.val;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            Node newNode = new Node(val);
            head = newNode;

        } else {
            Node p = head;
            for (int i = 0; i < size - 1; i++) {
                p = p.next;
            }
            p.next = new Node(val);
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            size++;
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            Node newNode = new Node(val);
            newNode.next = p.next;
            p.next = newNode;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}
