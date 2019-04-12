package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * TODO: tricky - just understand - check for current.next=null so that you end up in the node you want not the next one.
 */
public class ReturnKthToLast {
    @Test
    public void testSimple() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n1.next(n2).next(n3).next(n4).next(n5).next(n6).next(n6).next(n7).next(n8).next(n9);
        TestCase.assertEquals(n9, doReturnKthToLast(n1, 0));
        TestCase.assertEquals(n8, doReturnKthToLast(n1, 1));
        TestCase.assertEquals(n7, doReturnKthToLast(n1, 2));
        TestCase.assertEquals(n6, doReturnKthToLast(n1, 3));
        TestCase.assertEquals(n5, doReturnKthToLast(n1, 4));
        TestCase.assertEquals(n4, doReturnKthToLast(n1, 5));
        TestCase.assertEquals(n3, doReturnKthToLast(n1, 6));
        TestCase.assertEquals(n2, doReturnKthToLast(n1, 7));
        TestCase.assertEquals(n1, doReturnKthToLast(n1, 8));
    }

    public Node doReturnKthToLast(Node root, int K) {
        Node runner = root;
        Node current = root;
        for (int i = 0; i < K; i++) runner = runner.next;
        while (runner.next != null) {
            runner = runner.next;
            current = current.next;
        }
        return current;
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
