package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Objects;

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
        assertFalse(doCheckBalanced(n0));
    }

    /**
     * True by Definition
     */
    @Test
    public void testSimple5() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n0.left(n1);
        n0.right(n6);
        n1.left(n2);
        n1.right(n3);
        n2.left(n4);
        n3.right(n5);
        n6.right(n7);
        assertTrue(doCheckBalanced(n0));
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

    //////////////
    // SOLUTION //
    //////////////
    Result badResult = new Result(-1, false);

    public boolean doCheckBalanced(Node root) {
        return doCheckBalancedDoer(root).result;
    }

    public Result doCheckBalancedDoer(Node root) {
        if (root == null) return new Result(0, true);
        Result left = doCheckBalancedDoer(root.left);
        if (!left.result) return badResult;
        Result right = doCheckBalancedDoer(root.right);
        if (!right.result) return badResult;
        int diff = Math.abs(left.height - right.height);
        if (diff > 1) return badResult;
        else return new Result(Math.max(left.height, right.height) + 1, true);
    }

    class Result {
        int height = -1;
        boolean result;

        public Result(int height, boolean result) {
            this.height = height;
            this.result = result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result1 = (Result) o;
            return height == result1.height &&
                    result == result1.result;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, result);
        }
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
