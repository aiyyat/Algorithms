package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

public class BiNode {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        n1.left = n0;
        n4.right = n5;
        n5.right = n6;
        Node result = doBiNode(n4);
        System.out.println(result);
        System.out.println(result.from());
        System.out.println(result.from().from());
        System.out.println(result.from().from().from());
        System.out.println(result.from().from().from().from());
        System.out.println(result.from().from().from().from().from());
        System.out.println(result.from().from().from().from().from().from());
        System.out.println(result.from().from().from().from().from().from().from());
        System.out.println(result.from().from().from().from().from().from());
        System.out.println(result.from().from().from().from().from().from().to());
        System.out.println(result.from().from().from().from().from().from().to().to());
        System.out.println(result.from().from().from().from().from().from().to().to().to());
        System.out.println(result.from().from().from().from().from().from().to().to().to().to());
        System.out.println(result.from().from().from().from().from().from().to().to().to().to().to());
        System.out.println(result.from().from().from().from().from().from().to().to().to().to().to().to());
        System.out.println(result.from().from().from().from().from().from().to().to().to().to().to().to().to());
    }

    public Node doBiNode(Node root) {
        if (root == null) return null;
        Node left = doBiNode(root.left);
        Node right = root.right;
        Node rightXtreme = doBiNode(right);
        if (left != null) {
            left.to(root);
            root.from(left);
        }
        if (right != null) {
            root.to(right);
            right.from(root);
            return rightXtreme;
        }
        return root;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public int data() {
            return data;
        }

        public void data(int data) {
            this.data = data;
        }

        public Node left() {
            return left;
        }

        public void left(Node node1) {
            this.left = node1;
        }

        public Node right() {
            return right;
        }

        public void right(Node right) {
            this.right = right;
        }

        public Node to() {
            return left;
        }

        public void to(Node node1) {
            this.left = node1;
        }

        public Node from() {
            return right;
        }

        public void from(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
