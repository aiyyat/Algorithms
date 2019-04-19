package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO: Read the question properly.
 */
public class SumLists {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        Node n1 = new NodeBuilder().add(7).add(1).add(6).build();
        Node n2 = new NodeBuilder().add(7).add(1).add(6).build();
        Node n3 = new NodeBuilder().add(4).add(3).add(2).add(1).build();
        for (Node node = sum(n1, n2); node != null; node = node.next, n3 = n3.next) {
            assertEquals(node.data, n3.data);
        }
    }

    @Test
    public void ctciTest() {
        Node n1 = new NodeBuilder().add(7).add(1).add(6).build();
        Node n2 = new NodeBuilder().add(5).add(9).add(2).build();
        Node n3 = new NodeBuilder().add(2).add(1).add(9).build();
        for (Node node = sum(n1, n2); node != null; node = node.next) {
            System.out.println(node);
        }
    }

    public Node sum(Node n1, Node n2) {
        Node current = new Node(0);
        Node root = current;
        while (true) {
            if (n1 == null && n2 == null) return root;
            if (current == null) current = new Node(0);
            int sum = (n1 == null ? 0 : n1.data) + (n2 == null ? 0 : n2.data);
            int d1 = sum % 10;
            int d2 = sum / 10;
            current.data += d1;
            current.next = d2 > 0 ? new Node(d2) : null;
            current = current.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
    }

    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void next(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    class NodeBuilder {
        Node root;
        Node next;

        public NodeBuilder add(Node node) {
            if (root == null) root = next = node;
            else {
                next.next = node;
                next = node;
            }
            return this;
        }

        public NodeBuilder add(Integer data) {
            return add(new Node(data));
        }

        public Node build() {
            return root;
        }
    }
}
