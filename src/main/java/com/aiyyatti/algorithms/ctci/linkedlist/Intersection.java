package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class Intersection {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void ctciTest() {
        Node common = new NodeBuilder().add(7).add(2).add(1).build();
        Node root1 = new NodeBuilder().add(3).add(1).add(5).add(9).add(common).build();
        Node root2 = new NodeBuilder().add(4).add(6).add(common).build();
        Node intersectionNode = doIntersection(root1, root2);
        assertEquals(7, intersectionNode.data);
    }

    @Test
    public void nonIntersectionTest() {
        Node root1 = new NodeBuilder().add(3).add(1).add(5).add(9).build();
        Node root2 = new NodeBuilder().add(4).add(6).build();
        Node intersectionNode = doIntersection(root1, root2);
        assertNull(intersectionNode);
    }

    public Node doIntersection(Node root1, Node root2) {
        int N1 = 0, N2 = 0;
        for (Node node = root1; node != null; node = node.next) N1++;
        for (Node node = root2; node != null; node = node.next) N2++;
        int diff = N1 - N2;
        Node longer = root1;
        Node shorter = root2;
        if (diff < 0) {
            shorter = root1;
            longer = root2;
        }

        for (int i = 0; i < Math.abs(diff); i++) longer = longer.next;
        while (shorter != null) {
            if (shorter.data == longer.data) return shorter;
            else {
                shorter = shorter.next;
                longer = longer.next;
            }
        }
        return null;
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
