package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 * <p>
 * <p>
 * TODO
 * Rule: For a tree to be balanced the absolute value of the left and
 * right node heights should be 0 or 1
 */
public class CheckBalanced {

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimpleNotBalanced() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n0.left(n1);
        n0.right(n5);
        n1.left(n2);
        n1.right(n3);
        n3.right(n4);
        n5.left(n6);
        n5.right(n7);
        n4.left(n8);
        assertFalse(doCheckBalanced(n0));
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
        assertFalse(doCheckBalanced(n5));
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
        assertTrue(doCheckBalanced(n5));
    }

    @Test
    public void simple2Test() {
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
        assertTrue(doCheckBalanced(n5));
    }

    @Test
    public void simple5Test() {
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
        assertTrue(doCheckBalanced(n5));
    }

    /**
     * return the difference between left and right subtrees if it is 0 or 1 then return that value
     *
     * @param root
     * @return
     */
    public boolean doCheckBalanced(Node root) {
        return doCheckBalanced(root, null, null);
    }

    public boolean doCheckBalanced(Node root, Integer min, Integer max) {
        if (root == null) return true;
        if ((max != null && root.data > max) || (min != null && root.data < min)) return false;
        if (!doCheckBalanced(root.left, min, root.data) || !doCheckBalanced(root.right, root.data, max)) {
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
        public String toString() {
            return data.toString();
        }
    }
}
