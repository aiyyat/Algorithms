package com.aiyyatti.algorithms.ctci.treeandgraphs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which
 * might be positive or negative). Design an algorithm to count the number of paths that sum to a
 * given value. The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 *
 * TODO test with more testcases.
 */
public class PathWithSum {
    LookupTable lookupTable = new LookupTable();

    private int doPathWithSum(Node root, int sum, int sumTillNow) {
        if (root == null) return 0;
        int found = 0;
        sumTillNow += root.data;
        int diffFromSum = sumTillNow - sum;
        found += lookupTable.get(diffFromSum) + ((sumTillNow == sum) ? 1 : 0);
        lookupTable.increment(sumTillNow);
        found += doPathWithSum(root.left, sum, sumTillNow);
        found += doPathWithSum(root.right, sum, sumTillNow);
        lookupTable.decrement(sumTillNow);
        return found;
    }

    class LookupTable {
        private Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();

        public int get(int i) {
            return lookup.getOrDefault(i, 0);
        }

        public void increment(int i) {
            add(i, 1);
        }

        public void decrement(int i) {
            add(i, -1);
        }

        public void add(int i, int j) {
            lookup.put(i, get(i));
        }
    }

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        int[] elements = new int[]{0, 1, -2, 1, 3, 1, 2, 1, -1, 1, 2, 0, 2, 1, 1, 2, 4, 2, 2, 5};
        Node root = convertToTree(elements);
        System.out.println(doPathWithSum(root, 4, 0));

    }

    private Node convertToTree(int[] elements) {
        return convertToTree(elements, 0, elements.length - 1);
    }

    private Node convertToTree(int[] elements, int start, int end) {
        if (start > end) return null;
        else {
            int mid = (start + end) / 2;
            Node node = new Node(elements[mid]);
            node.left(convertToTree(elements, start, mid - 1));
            node.right(convertToTree(elements, mid + 1, end));
            return node;
        }
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Node {
        int data;
        Node left;
        Node right;

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

        public void right(Node left, Node right) {
            left(left);
            right(right);
        }

        @Override
        public String toString() {
            return (left + " " + data + " " + right).replaceAll("null", "");
        }
    }
}
