package com.example.reversedList;


public class LinkedList {
    public static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
            next = null;
        }
    }

    Node head;

    public LinkedList(Node head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        this.head = head;
    }

    public void append(Node next) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = next;
    }

    public LinkedList getReverseIterative() {
        Node current = head;
        Node reverseHead = new Node(head.value);

        while (current.next != null) {
            Node reverseNext = reverseHead;
            reverseHead = new Node(current.next.value);
            reverseHead.next = reverseNext;
            current = current.next;
        }

        return new LinkedList(reverseHead);
    }

    public void reverseIterative() {
        Node current = head;
        Node reverse = null;

        while (current != null) {
            Node next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }

        head = reverse;
    }

    private Node reverseRecursiveHelper(Node n) {
        // empty list
        if (n == null) return null;

        // end of list | one element list
        if (n.next == null) return n;

        // saving pointer to remainder of list
        Node nextNode = n.next;

        // un-linking list to avoid cycle
        n.next = null;

        // recursive call on the remainder of the list
        Node reverse = reverseRecursiveHelper(nextNode);

        // re-linking lists
        nextNode.next = n;

        return reverse;
    }

    public void reverseRecursive() {
        head = reverseRecursiveHelper(head);
    }

    public void print() {
        Node tmp = head;
        while (tmp.next != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
        System.out.println(tmp.value);
    }
}
