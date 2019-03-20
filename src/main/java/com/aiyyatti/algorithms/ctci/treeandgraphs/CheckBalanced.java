package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 * <p>
 * <p>
 * TODO
 * Read the definition properly.
 */
public class CheckBalanced {
    /**
     * return the difference between left and right subtrees if it is 0 or 1 then return that value
     *
     * @param root
     * @return
     */
    public boolean doCheckBalanced(Node root) {
        return heightDiff(root) != Integer.MIN_VALUE;
    }

    public int heightDiff(Node root) {
        if (root == null) return -1;
        else {
            int heightLeft = heightDiff(root.left);
            int heightRight = heightDiff(root.right);
            if (heightLeft == Integer.MIN_VALUE || heightRight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (Math.abs(heightLeft - heightRight) > 1) {
                return Integer.MIN_VALUE;
            }
            return Math.max(heightLeft, heightRight) + 1;
        }
    }

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
        TestCase.assertFalse(doCheckBalanced(n0));
    }

    @Test
    public void testSimple3() {
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
        n4.right(n8);
        n5.left(n6);
        n5.right(n7);
        TestCase.assertFalse(doCheckBalanced(n0));
    }
    @Test
    public void testSimple4() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n0.left(n1);
        n0.right(n5);
        n1.left(n2);
        n1.right(n3);
        n3.right(n8);
        n5.left(n6);
        n5.right(n7);
        TestCase.assertTrue(doCheckBalanced(n0));
    }

    @Test
    public void testSimpleBalanced() {
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
        n1.left(n2);
        n1.right(n3);
        n3.right(n4);
        n5.left(n6);
        n5.right(n7);
        TestCase.assertTrue(doCheckBalanced(n0));
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
