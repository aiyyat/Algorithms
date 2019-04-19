package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DeleteMiddleNode {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        n1.next(n2).next(n3).next(n4).next(n5).next(n6).next(n7).next(n8).next(n9).next(n10).next(n11);
        assertEquals(n1.next().next().next().next().next(), n6);
        doDeleteMiddleNode(n5);
        assertEquals(n1.next().next().next().next().next(), n7);
    }

    public void doDeleteMiddleNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public Node next(Node next) {
            this.next = next;
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
