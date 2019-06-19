package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo: circluar
 * Redo: Yes
 * Notes:
 */
public class BiNode {
    private static final Logger logger = getLogger(Bi.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n4.left(n2);
        n2.left(n1);
        n1.left(n0);
        n6.left(n5);
        n4.right(n6);
        n2.right(n3);
        n6.right(n7);
        Bi bi = convert(n4);
        Bi zero = bi.prev().prev().prev().prev();
        assertThat(zero.data).isEqualTo(0);
        assertThat(zero.next().data).isEqualTo(1);
        assertThat(zero.next().next().data).isEqualTo(2);
        assertThat(zero.next().next().next().data).isEqualTo(3);
        assertThat(zero.next().next().next().next().data).isEqualTo(4);
        assertThat(zero.next().next().next().next().next().data).isEqualTo(5);
        assertThat(zero.next().next().next().next().next().next().data).isEqualTo(6);
        Bi seven = zero.next().next().next().next().next().next().next();
        assertThat(seven.data).isEqualTo(7);
        assertThat(seven.prev().data).isEqualTo(6);
    }

    //////////////
    // SOLUTION //
    //////////////
    public Bi convert(Node root) {
        if (root == null) return null;
        Bi leftRoot = convert(root.left);
        Bi rightRoot = convert(root.right);
        return connect(leftRoot, root, rightRoot);
    }

    public Bi connect(Bi left, Node root, Bi right) {
        while (left != null && left.next != null) {
            left = left.next;
        }
        while (right != null && right.prev != null) {
            right = right.prev;
        }
        Bi biRoot = new Bi(root.data);
        biRoot.prev(left);
        biRoot.next(right);
        if (left != null) left.next(biRoot);
        if (right != null) right.prev(biRoot);
        return biRoot;
    }

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public Node left() {
            return left;
        }

        public void left(Node left) {
            this.left = left;
        }

        public Node right() {
            return right;
        }

        public void right(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    class Bi {
        Bi next, prev;
        int data;

        public Bi(int data) {
            this.data = data;
        }

        public Bi(Bi next, Bi prev) {
            this.next = next;
            this.prev = prev;
        }

        public Bi next() {
            return next;
        }

        public void next(Bi next) {
            this.next = next;
        }

        public Bi prev() {
            return prev;
        }

        public void prev(Bi prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Bi{" +
                    "data=" + data +
                    '}';
        }
    }
}
