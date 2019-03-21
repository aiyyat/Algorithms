package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print all possible
 * arrays that could have led to this tree.
 * <p>
 * Time Complexity: O(n^3)
 */
public class BSTSequence {
    public ArrayList<LinkedList<Integer>> doBSTSequence(Node root) {
        if (root == null) {
            ArrayList<LinkedList<Integer>> result = new ArrayList<>();
            result.add(new LinkedList<>());
            return result;
        }
        ArrayList<LinkedList<Integer>> left = doBSTSequence(root.left);
        ArrayList<LinkedList<Integer>> right = doBSTSequence(root.right);
        ArrayList<LinkedList<Integer>> output = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> rootData = new LinkedList<>();
        rootData.add(root.data);
        for (int i = 0; i < left.size(); i++)
            for (int j = 0; j < right.size(); j++)
                weave(left.get(i), right.get(j), output, rootData);
        return output;
    }

    public void weave(LinkedList<Integer> left, LinkedList<Integer> right, ArrayList<LinkedList<Integer>> output, LinkedList<Integer> prefix) {
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(prefix);
            result.addAll(right);
            result.addAll(left);
            output.add(result);
            return;
        } else {
            prefix.add(left.removeFirst());
            weave(left, right, output, prefix);
            left.add(prefix.removeLast());

            prefix.add(right.removeFirst());
            weave(left, right, output, prefix);
            right.add(prefix.removeLast());
        }
    }


    ////////////////
    // TEST CASES //
    ////////////////

    @Test
    public void simpleBSTTest0() {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n9 = new Node(9);
        n5.left(n3);
        n5.right(n7);
        n7.left(n6);
        n7.right(n9);
        n3.left(n1);
        n3.right(n4);
        TestCase.assertEquals("[[5, 3, 1, 4, 7, 6, 9], [5, 3, 1, 7, 4, 6, 9], [5, 3, 1, 7, 6, 4, 9], [5, 3, 1, 7, 6, 9, 4], [5, 3, 9, 4, 1, 6, 7], [5, 3, 9, 4, 6, 1, 7], [5, 3, 9, 4, 6, 7, 1], [5, 3, 9, 7, 1, 4, 6], [5, 3, 9, 7, 1, 6, 4], [5, 3, 9, 7, 6, 4, 1], [5, 6, 4, 1, 3, 7, 9], [5, 6, 4, 1, 7, 3, 9], [5, 6, 4, 1, 7, 9, 3], [5, 6, 4, 9, 3, 1, 7], [5, 6, 4, 9, 3, 7, 1], [5, 6, 4, 9, 7, 1, 3], [5, 6, 7, 1, 3, 4, 9], [5, 6, 7, 1, 3, 9, 4], [5, 6, 7, 1, 9, 4, 3], [5, 6, 7, 9, 4, 3, 1], [5, 4, 3, 1, 7, 9, 6], [5, 4, 3, 7, 1, 9, 6], [5, 4, 3, 7, 9, 1, 6], [5, 4, 3, 7, 9, 6, 1], [5, 4, 6, 1, 3, 9, 7], [5, 4, 6, 1, 9, 3, 7], [5, 4, 6, 1, 9, 7, 3], [5, 4, 6, 7, 3, 1, 9], [5, 4, 6, 7, 3, 9, 1], [5, 4, 6, 7, 9, 1, 3], [5, 9, 1, 3, 4, 7, 6], [5, 9, 1, 3, 7, 4, 6], [5, 9, 1, 3, 7, 6, 4], [5, 9, 1, 6, 4, 3, 7], [5, 9, 1, 6, 4, 7, 3], [5, 9, 1, 6, 7, 3, 4], [5, 9, 7, 3, 4, 1, 6], [5, 9, 7, 3, 4, 6, 1], [5, 9, 7, 3, 6, 1, 4], [5, 9, 7, 6, 1, 4, 3], [5, 3, 4, 1, 9, 7, 6], [5, 3, 4, 9, 1, 7, 6], [5, 3, 4, 9, 7, 1, 6], [5, 3, 4, 9, 7, 6, 1], [5, 3, 6, 1, 4, 7, 9], [5, 3, 6, 1, 7, 4, 9], [5, 3, 6, 1, 7, 9, 4], [5, 3, 6, 9, 4, 1, 7], [5, 3, 6, 9, 4, 7, 1], [5, 3, 6, 9, 7, 1, 4], [5, 7, 1, 4, 3, 9, 6], [5, 7, 1, 4, 9, 3, 6], [5, 7, 1, 4, 9, 6, 3], [5, 7, 1, 6, 3, 4, 9], [5, 7, 1, 6, 3, 9, 4], [5, 7, 1, 6, 9, 4, 3], [5, 7, 9, 4, 3, 1, 6], [5, 7, 9, 4, 3, 6, 1], [5, 7, 9, 4, 6, 1, 3], [5, 7, 9, 6, 1, 3, 4], [5, 1, 3, 4, 6, 7, 9], [5, 1, 3, 6, 4, 7, 9], [5, 1, 3, 6, 7, 4, 9], [5, 1, 3, 6, 7, 9, 4], [5, 1, 9, 4, 3, 7, 6], [5, 1, 9, 4, 7, 3, 6], [5, 1, 9, 4, 7, 6, 3], [5, 1, 9, 6, 3, 4, 7], [5, 1, 9, 6, 3, 7, 4], [5, 1, 9, 6, 7, 4, 3], [5, 7, 4, 3, 1, 6, 9], [5, 7, 4, 3, 6, 1, 9], [5, 7, 4, 3, 6, 9, 1], [5, 7, 4, 9, 1, 3, 6], [5, 7, 4, 9, 1, 6, 3], [5, 7, 4, 9, 6, 3, 1], [5, 7, 6, 3, 1, 4, 9], [5, 7, 6, 3, 1, 9, 4], [5, 7, 6, 3, 9, 4, 1], [5, 7, 6, 9, 4, 1, 3]]\n", doBSTSequence(n5).toString());
    }

    @Test
    public void simpleBSTTest1() {
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        n5.left(n3);
        n5.right(n7);
        TestCase.assertEquals("[[5, 3, 7], [5, 7, 3]]", doBSTSequence(n5).toString());
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
