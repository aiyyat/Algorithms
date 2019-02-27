package com.aiyyatti.algorithms.tree.ctci;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height
 */
public class MinimalTree {
    public Node doMinimalTree(int[] input) {
        return doMinimalTree(0, input.length, input);
    }

    public Node doMinimalTree(int start, int end, int[] input) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        Node node = new Node(input[mid]);
        node.left(doMinimalTree(start, mid - 1, input));
        node.right(doMinimalTree(mid, end - 1, input));
        return node;
    }

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
        int[] input = new int[]{7, 3, 1, 4, 0, 5, 2, 6};
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n0.left(n1);
        n0.right(n5);
        n1.left(n1);
        n1.right(n3);
        n3.right(n4);
        n0.right(n5);
        n5.left(n6);
        n5.right(n7);
        TestCase.assertEquals(n0, doMinimalTree(input));
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Node {
        Node left;
        Node right;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }

        public Node left() {
            return left;
        }

        public Node right() {
            return right;
        }

        public void left(Node left) {
            this.left = left;
        }

        public void right(Node left) {
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            Node otherNode = (Node) obj;
            Node thisNode = this;
            if (otherNode == null && thisNode == null) {
                return true;
            } else if (otherNode != null && thisNode != null) {
                return otherNode.data.equals(thisNode.data) && otherNode.left.equals(thisNode.left) && otherNode.right.equals(thisNode.right);
            }
            return false;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
