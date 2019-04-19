package com.aiyyatti.algorithms.gfg;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/sum-k-smallest-elements-bst/
 */
public class SumOfKSmallestElementsInBST {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        Node n8 = new Node(8);
        Node n7 = new Node(7);
        Node n10 = new Node(10);
        Node n2 = new Node(2);
        Node n9 = new Node(9);
        Node n13 = new Node(13);
        n8.left(n7);
        n8.right(n10);
        n7.left(n2);
        n10.left(n9);
        n10.right(n13);
        TestCase.assertEquals(17, doSumKSmallestElementsBst(n8, 3, new Result()).sum());
    }

    /**
     *            8
     *          /   \
     *         5    11
     *       /  \
     *      2    7
     *       \
     *        3
     */
    @Test
    public void simple1Test() {
        Node n8 = new Node(8);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n11 = new Node(11);
        n8.left(n5);
        n8.right(n11);
        n5.left(n2);
        n5.right(n7);
        n2.right(n3);
        TestCase.assertEquals(25, doSumKSmallestElementsBst(n8, 5, new Result()).sum());
    }


    public Result doSumKSmallestElementsBst(Node root, int K, Result result) {
        if (root == null) return null;
        else {
            Result leftResult = doSumKSmallestElementsBst(root.left, K, result);
            if (leftResult == null && !result.isStarted()) {
                result.startCounting();
            }
            if (result.isStarted() && result.count() < K) {
                result.sum(root.data);
            }
            doSumKSmallestElementsBst(root.right, K, result);
        }
        return result;
    }

    class Result {
        int count;
        int sum;
        boolean startCounting = false;

        public int count() {
            return count;
        }

        public void incrementCount() {
            count++;
        }

        public void count(int count) {
            this.count = count;
        }

        public int sum() {
            return sum;
        }

        public void sum(int sum) {
            this.sum += sum;
            incrementCount();
        }

        public boolean isStarted() {
            return startCounting;
        }

        public void startCounting() {
            this.startCounting = true;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "count=" + count +
                    ", sum=" + sum +
                    ", startCounting=" + startCounting +
                    '}';
        }
    }

    class Node {
        Node left;
        Node right;
        int data;

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

        public int data() {
            return data;
        }

        public void data(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
