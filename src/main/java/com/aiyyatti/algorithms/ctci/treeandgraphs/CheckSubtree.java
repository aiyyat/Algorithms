package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of T1 if there exists a node n in Tl such that the subtree of n is identical to T2 .
 * That is, if you cut off the tree at node n, the two trees would be identical.
 *
 * TODO: Easy yet review.
 */
public class CheckSubtree {
    public boolean isSubTree(Node t1, Node t2) {
        if (t1 == null) return false;
        if (t2 == null) return true;
        boolean output = false;
        if (t1.data == t2.data) {
            output = checkSubTree(t1, t2);
        }
        if (output == true) return true;
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }

    public boolean checkSubTree(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        else if (t1.data != t2.data) {
            System.out.printf("%s %s", t1, t2);
            return false;
        } else return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
    }

    @Test
    public void testSimpleSameTree() {
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

        Node t0 = new Node(0);
        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        Node t6 = new Node(6);
        Node t7 = new Node(7);
        t0.left(t1);
        t0.right(t5);
        t1.left(t2);
        t1.right(t3);
        t3.right(t4);
        t5.left(t6);
        t5.right(t7);
        TestCase.assertTrue(isSubTree(n0, t0));
    }

    @Test
    public void testSimpleSubTree() {
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

        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        Node t6 = new Node(6);
        Node t7 = new Node(7);
        Node t8 = new Node(8);
        t3.right(t4);
        t4.left(t8);
        TestCase.assertFalse(isSubTree(n0, t3));
    }

    @Test
    public void testSimpleNotSubTree() {
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

        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(51);
        Node t6 = new Node(6);
        Node t7 = new Node(7);
        t3.right(t4);
        t5.left(t6);
        t5.right(t7);
        TestCase.assertTrue(isSubTree(n0, t3));
    }

    @Test
    public void testSimpleNotSameTree() {
        Node n0 = new Node(0);
        Node n1 = new Node(11);
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

        Node t0 = new Node(0);
        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        Node t6 = new Node(6);
        Node t7 = new Node(7);
        t0.left(t1);
        t0.right(t5);
        t1.left(t2);
        t1.right(t3);
        t3.right(t4);
        t5.left(t6);
        t5.right(t7);
        TestCase.assertFalse(isSubTree(n0, t0));
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Node {
        private Integer data;
        private Node left;
        private Node right;

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
