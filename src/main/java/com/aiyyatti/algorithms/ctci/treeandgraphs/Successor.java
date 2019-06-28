package com.aiyyatti.algorithms.ctci.treeandgraphs;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent
 */
public class Successor {
    @Test
    public void testSimple() {
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
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        n7.left(n3);
        n3.left(n2);
        n2.left(n1);
        n5.left(n4);
        n11.left(n9);
        n9.left(n8);
        n13.left(n12);
        n7.right(n11);
        n3.right(n5);
        n5.right(n6);
        n9.right(n10);
        n11.right(n13);
        n13.right(n14);
        assertEquals(4, doSuccessor(n3).data);
        assertEquals(2, doSuccessor(n1).data);
        assertEquals(5, doSuccessor(n4).data);
        assertEquals(3, doSuccessor(n2).data);
        assertEquals(13, doSuccessor(n12).data);
        assertEquals(9, doSuccessor(n8).data);
        assertEquals(14, doSuccessor(n13).data);
        assertEquals(12, doSuccessor(n11).data);
        assertEquals(8, doSuccessor(n7).data);
        assertEquals(6, doSuccessor(n5).data);
        assertEquals(7, doSuccessor(n6).data);
        assertEquals(10, doSuccessor(n9).data);
        assertEquals(11, doSuccessor(n10).data);
        assertNull(doSuccessor(n14));
    }

    @Test
    public void testOneOffCase() {
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
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        n7.left(n3);
        n3.left(n2);
        n2.left(n1);
        n5.left(n4);
        n11.left(n9);
        n9.left(n8);
        n13.left(n12);
        n7.right(n11);
        n3.right(n5);
        n5.right(n6);
        n9.right(n10);
        n11.right(n13);
        n13.right(n14);
        assertEquals(7, doSuccessor(n6).data);
    }

    @Test
    public void testCase1() {
        Node n1 = new Node(1);
        assertNull(doSuccessor(n1));
    }

    @Test
    public void testCase2() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.right(n2);
        assertNull(doSuccessor(n2));
    }

    @Test
    public void testCase3() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.right(n2);
        n1.left(n3);
        assertEquals(1, doSuccessor(n3).data);
    }

    @Test
    public void testCase4() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.right(n2);
        n1.left(n3);
        assertEquals(2, doSuccessor(n1).data);
    }

    @Test
    public void testCase5() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.right(n2);
        n1.left(n3);
        assertNull(doSuccessor(n2));
    }

    public Node doSuccessor(Node root) {
        if (root.hasRight()) {
            root = root.right;
            Node lastLeft = root;
            while (root.hasLeft()) {
                lastLeft = root.left;
                root = root.left;
            }
            return lastLeft;
        } else {
            Node parent = root.parent;
            if (root.isOnLeftOf(parent)) return parent;
            else {
                while (root.isOnRightOf(parent)) {
                    root = parent;
                    parent = root.parent;
                }
                return parent;
            }
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        public boolean hasRight() {
            return right != null;
        }

        public boolean isOnLeftOf(Node node) {
            return node == null ? false : node.left == this;
        }

        public boolean isOnRightOf(Node node) {
            return node == null ? false : node.right == this;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node left() {
            return left;
        }

        public void left(Node left) {
            left.parent(this);
            this.left = left;
        }

        public Node right() {
            return right;
        }

        public void right(Node right) {
            right.parent(this);
            this.right = right;
        }

        public Node parent() {
            return parent;
        }

        public void parent(Node parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
