package com.aiyyatti.algorithms.tree.ctci;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 * <p>
 * <p>
 * FIXME:
 * output.get(level) will throw java.lang.IndexOutOfBoundsException: Index 0
 * out of bounds for length 0 so check for size.
 */
public class ListOfDepths {
    public List<LinkedList<Node>> doListOfDepths(Node root) {
        ArrayList<LinkedList<Node>> output = new ArrayList<>();
        doListOfDepths(root, output, 0);
        return output;
    }

    /**
     * Time Complexity: O(n)
     *
     * @param root
     * @param output
     * @param level
     */
    public void doListOfDepths(Node root, ArrayList<LinkedList<Node>> output, int level) {
        if (root == null) return;
        LinkedList<Node> entry = null;
        if (output.size() <= level) {
            entry = new LinkedList<>();
            output.add(level, entry);
        } else {
            entry = output.get(level);
        }
        entry.add(root);
        doListOfDepths(root.left, output, level + 1);
        doListOfDepths(root.right, output, level + 1);
    }

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
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
        TestCase.assertEquals("[[0], [1, 2], [3, 4, 7, 8], [5, 6, 9]]", doListOfDepths(n0).toString());
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