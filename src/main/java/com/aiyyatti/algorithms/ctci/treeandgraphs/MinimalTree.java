package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height
 * <p>
 * TODO:
 * public Node doMinimalTree(int start, int end, int[] input) => end not end-1
 */
public class MinimalTree {
    Logger logger = LoggerFactory.getLogger(MinimalTree.class);

    public Node doMinimalTree(int[] input) {
        return doMinimalTree(0, input.length - 1, input);
    }

    /**
     * Time Complexity: O(n)
     *
     * @param start
     * @param end
     * @param input
     * @return
     */
    public Node doMinimalTree(int start, int end, int[] input) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        Node node = new Node(input[mid]);
        node.left(doMinimalTree(start, mid - 1, input));
        node.right(doMinimalTree(mid + 1, end, input));
        return node;
    }

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
        int[] input = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n3.left(n1);
        n3.right(n5);
        n1.left(n0);
        n1.right(n2);
        n5.left(n4);
        n5.right(n6);
        n6.right(n7);
        TestCase.assertEquals(n3, doMinimalTree(input));
    }

    @Test
    public void test2Simple() {
        int[] input = new int[]{0, 1, 2, 3, 4, 5, 6};
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n3.left(n1);
        n3.right(n5);
        n1.left(n0);
        n1.right(n2);
        n5.left(n4);
        n5.right(n6);
        TestCase.assertEquals(n3, doMinimalTree(input));
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

        public void right(Node right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            Node thatNode = (Node) obj;
            Node thisNode = this;
            return check(thisNode).equals(check(thatNode));
        }

        public String check(Node root) {
            if (root == null) return "X";
            return root.data + " " + check(root.left) + " " + check(root.right) + " ";
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
