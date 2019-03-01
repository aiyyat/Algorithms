package com.aiyyatti.algorithms.tree.ctci;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class FirstCommonAncestor {
    ////////////////
    // APPROACH 1 //
    ////////////////
    public Node commonAncestor1(Node root, Node a, Node b) {
        if (root == null) return null;
        if (root == a && root == b) return root;
        if (root == a || root == b) return root;
        boolean isAOnLeft = isIn(root.left, a);
        boolean isBOnLeft = isIn(root.left, b);
        if (isAOnLeft && isBOnLeft) {
            return commonAncestor1(root.left, a, b);
        } else if (!isAOnLeft && !isBOnLeft) {
            return commonAncestor1(root.right, a, b);
        } else {
            return root;
        }
    }

    public boolean isIn(Node root, Node node) {
        if (root == null) return false;
        if (root == node) return true;
        return isIn(root.left, node) || isIn(root.right, node);
    }
    ////////////////
    // APPROACH 2 //
    ////////////////

    ////////////////
    // Test CASES //
    ////////////////
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
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(11);
        n0.left(n1);
        n0.right(n4);
        n1.left(n2);
        n1.right(n3);
        n2.left(n12);
        n2.right(n7);
        n7.left(n8);
        n7.right(n9);
        n9.left(n11);
        n9.right(n10);
        n4.left(n5);
        n4.right(n6);
        TestCase.assertEquals(n7, commonAncestor1(n0, n9, n7));
    }

    @Test
    public void simpleTest2() {
        Node n0 = new Node(0);
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
        Node n12 = new Node(11);
        n0.left(n1);
        n0.right(n4);
        n1.left(n2);
        n1.right(n3);
        n2.left(n12);
        n2.right(n7);
        n7.left(n8);
        n7.right(n9);
        n9.left(n11);
        n9.right(n10);
        n4.left(n5);
        n4.right(n6);
        TestCase.assertEquals(n7, commonAncestor1(n0, n8, n10));
    }


    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Node {
        int data;
        Node left;
        Node right;

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
            return "" + data;
        }
    }
}
