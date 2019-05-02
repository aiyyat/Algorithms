package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
        TestCase.assertEquals(4, doSuccessor(n3).data);
        TestCase.assertEquals(2, doSuccessor(n1).data);
        TestCase.assertEquals(5, doSuccessor(n4).data);
        TestCase.assertEquals(3, doSuccessor(n2).data);
        TestCase.assertEquals(13, doSuccessor(n12).data);
        TestCase.assertEquals(9, doSuccessor(n8).data);
        TestCase.assertEquals(14, doSuccessor(n13).data);
        TestCase.assertEquals(12, doSuccessor(n11).data);
        TestCase.assertEquals(8, doSuccessor(n7).data);
        TestCase.assertEquals(6, doSuccessor(n5).data);
        TestCase.assertEquals(7, doSuccessor(n6).data);
        TestCase.assertEquals(10, doSuccessor(n9).data);
        TestCase.assertEquals(11, doSuccessor(n10).data);
        TestCase.assertNull(doSuccessor(n14));
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
        TestCase.assertEquals(7, doSuccessor(n6).data);
    }

    public Node doSuccessor(Node root) {
        Node right = root.right;
        if (right != null) {
            Node node = right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            Node parent = root.parent;
            while (parent != null && parent.left != root) {
                root = parent;
                parent = root.parent;
            }
            return parent;
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node parent;

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
