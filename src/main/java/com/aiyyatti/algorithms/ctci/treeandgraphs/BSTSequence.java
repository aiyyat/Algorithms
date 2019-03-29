package com.aiyyatti.algorithms.ctci.treeandgraphs;

import org.junit.Test;

import java.util.LinkedList;

/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print all possible
 * arrays that could have led to this tree.
 * <p>
 * Time Complexity: O(n)
 */
public class BSTSequence {

    public LinkedList<LinkedList<Integer>> doBSTSequence(Node root) {
        if (root == null) return new LinkedList<>();
        LinkedList<LinkedList<Integer>> left = doBSTSequence(root.left);
        LinkedList<LinkedList<Integer>> right = doBSTSequence(root.right);
        LinkedList<LinkedList<Integer>> output = new LinkedList<>();
        LinkedList<LinkedList<Integer>> prefix = new LinkedList<>();
        LinkedList<Integer> rootList = new LinkedList<>();
        rootList.add(root.data);
        prefix.add(rootList);
        weave(left, right, output, prefix);
        return output;
    }

    private void weave(LinkedList<LinkedList<Integer>> leftList, LinkedList<LinkedList<Integer>> rightList, LinkedList<LinkedList<Integer>> outputList, LinkedList<LinkedList<Integer>> prefixList) {
        if (leftList.isEmpty() || rightList.isEmpty()) {
            LinkedList<Integer> yetAnother = new LinkedList<>();
            prefixList.forEach(e -> yetAnother.addAll(e));
            leftList.forEach(e -> yetAnother.addAll(e));
            rightList.forEach(e -> yetAnother.addAll(e));
            outputList.add(yetAnother);
            return;
        }
        LinkedList<Integer> left = leftList.removeFirst();
        prefixList.add(left);
        weave(rightList, leftList, outputList, prefixList);
        prefixList.removeLast();

        LinkedList<Integer> right = rightList.removeFirst();
        prefixList.add(right);
        weave(leftList, rightList, outputList, prefixList);
        prefixList.removeLast();
    }

    ////////////////
    // TEST CASES //
    ////////////////
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
        System.out.println(doBSTSequence(n5));
    }

    @Test
    public void simplestTest() {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n5.left(n3);
        n5.right(n7);
        n7.left(n6);
        n7.right(n8);
        n3.left(n1);
        n3.right(n4);
        System.out.println(doBSTSequence(n5));
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
