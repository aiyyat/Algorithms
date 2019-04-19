package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Partition {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testPartition() {
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
        n1.next(n5).next(n6).next(n9).next(n3).next(n8).next(n11).next(n10).next(n2).next(n7).next(n4);
        String out = "";
        for (Node root = doPartition(n1, 5); root != null; root = root.next()) out += root.data + " ";
        assertEquals("1 5 3 2 4 6 9 8 11 10 7 ", out);

    }

    public Node doPartition(Node node, int target) {
        Node start1 = null, end1 = null;
        Node start2 = null, end2 = null;
        while (node != null) {
            if (node.data <= target) {
                if (start1 == null) start1 = end1 = node;
                else {
                    end1.next = node;
                    end1 = end1.next();
                }
            } else {
                if (start2 == null) start2 = end2 = node;
                else {
                    end2.next = node;
                    end2 = end2.next();
                }
            }
            node = node.next();
        }
        end1.next = start2;
        end2.next = null;
        return start1;
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
