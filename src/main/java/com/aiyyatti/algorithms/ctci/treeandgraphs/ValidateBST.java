package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBST {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleNotBSTTest() {
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
        n0.left(n1);
        n0.right(n2);
        n1.left(n3);
        n1.right(n4);
        n1.right(n4);
        n3.right(n5);
        n4.right(n6);
        n2.left(n7);
        n2.right(n8);
        n8.right(n9);
        TestCase.assertFalse(doValidateBST(n0));
    }

    @Test
    public void simpleBSTTest() {
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
        n5.left(n3);
        n5.right(n7);
        n7.left(n6);
        n7.right(n9);
        n9.left(n8);
        n9.right(n10);
        n3.left(n1);
        n3.right(n4);
        n1.left(n0);
        n1.right(n2);
        assertTrue(doValidateBST(n5));
    }

    @Test
    public void cornerCaseTest() {
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
        n5.left(n4);
        n5.right(n8);
        n4.left(n3);
        n4.right(n6);
        n8.left(n7);
        n8.right(n9);
        assertFalse(doValidateBST(n5));
    }

    @Test
    public void cornerCase2Test() {
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
        n5.left(n3);
        n5.right(n7);
        n3.left(n2);
        n3.right(n4);
        n7.left(n6);
        n7.right(n8);
        assertTrue(doValidateBST(n5));
    }

    @Test
    public void simple2Test() {
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        n5.left(n3);
        n5.right(n7);
        assertTrue(doValidateBST(n5));
    }

    //////////////
    // SOLUTION //
    //////////////
    public boolean doValidateBST(Node root) {
        return doValidateBST(root, null, null);
    }

    public boolean doValidateBST(Node root, Integer min, Integer max) {
        if (root == null) return true;
        if ((max != null && root.data > max) || (min != null && root.data < min)) return false;
        if (!doValidateBST(root.left, min, root.data) || !doValidateBST(root.right, root.data, max)) {
            return false;
        }
        return true;
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Node {
        Node left;
        Node right;
        Integer data;

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
            return data.toString();
        }
    }
}
