package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * TODO Tricky - repointing cornercases.
 */
public class RemoveDups {
    @Test
    public void simpleTest() {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(2);
        Node n6 = new Node(4);
        Node n7 = new Node(3);
        Node n8 = new Node(1);
        Node n9 = new Node(2);
        Node n10 = new Node(1);
        Node n11 = new Node(4);
        n1.next(n2).next(n3).next(n4).next(n5).next(n6).next(n7).next(n8).next(n9).next(n10).next(n11);
        removeDuplicates(n1);
        Node actual = n1;
        Node o1 = new Node(1);
        Node o2 = new Node(2);
        Node o3 = new Node(3);
        Node o4 = new Node(4);
        o1.next(o3).next(o2).next(o4);
        Node expected = o1;
        while (actual != null) {
            System.out.println(actual.data);
            TestCase.assertEquals(actual.data, expected.data);
            actual = actual.next();
            expected = expected.next();
        }
    }

    @Test
    public void simple2Test() {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        n1.next(n2);
        removeDuplicates(n1);
        Node actual = n1;
        Node o1 = new Node(1);
        Node o2 = new Node(3);
        o1.next(o2);
        Node expected = o1;
        while (actual != null) {
            TestCase.assertEquals(actual.data, expected.data);
            actual = actual.next();
            expected = expected.next();
        }
    }

    public void removeDuplicates(Node root) {
        Node current = root;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
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
            return "" + data;
        }
    }
}
