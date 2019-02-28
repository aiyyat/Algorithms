package com.aiyyatti.algorithms.tree.ctci;

import com.aiyyatti.algorithms.tree.misc.InOrderTraversalWithoutRecustion;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 *
 * TODO: need to ensure each node has left - right is 1 or 0 not just the root.
 */
public class CheckBalanced {
    public boolean doCheckBalanced(Node root) {
        int heightDiff = checkBalanced(root);
        if (heightDiff == 0 || heightDiff == 1) {
            return true;
        }
        return false;
    }

    /**
     * Time Complexity: O(n)
     * @param root
     * @return
     */
    public int checkBalanced(Node root) {
        if (root == null) return 0;
        else return (checkBalanced(root.left) - checkBalanced(root.right) + 1);
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
        n0.left(n1);
        n0.right(n5);
        n1.left(n2);
        n1.right(n3);
        n3.right(n4);
        n0.right(n5);
        n5.left(n6);
        n5.right(n7);
        TestCase.assertFalse(doCheckBalanced(n0));
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
        n0.right(n2);
        n1.left(n3);
        n1.right(n4);
        n3.right(n7);
        n2.left(n5);
        n2.right(n6);
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
