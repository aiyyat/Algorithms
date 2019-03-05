package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Random Node: You are implementing a binary search tree class from scratch, which, in addition
 * to insert, find, and delete, has a method getRandomNode() which returns a random node
 * from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 * for get RandomNode, and explain how you would implement the rest of the methods.
 * <p>
 * TODO: the getNode method is much more complicated than otherwise expected. Work it out well on paper before implementation.
 */
public class RandomNode {
    Logger logger = LoggerFactory.getLogger(RandomNode.class);

    //////////////
    // TEST CASE //
    //////////////
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
        Tree tree = new Tree(n5);
        tree.insertInOrder(n3);
        tree.insertInOrder(n7);
        tree.insertInOrder(n2);
        tree.insertInOrder(n1);
        tree.insertInOrder(n4);
        tree.insertInOrder(n6);
        tree.insertInOrder(n8);
        tree.insertInOrder(n9);
        TestCase.assertEquals(1, tree.getNode(n5, 1).data);
        TestCase.assertEquals(2, tree.getNode(n5, 2).data);
        TestCase.assertEquals(3, tree.getNode(n5, 4).data);
        TestCase.assertEquals(4, tree.getNode(n5, 3).data);
        TestCase.assertEquals(5, tree.getNode(n5, 9).data);
        TestCase.assertEquals(6, tree.getNode(n5, 5).data);
        TestCase.assertEquals(7, tree.getNode(n5, 8).data);
        TestCase.assertEquals(9, tree.getNode(n5, 6).data);
        TestCase.assertEquals(8, tree.getNode(n5, 7).data);
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void insertInOrder(Node node) {
            root.insertAsChild(node);
        }

        public Node getRandomNode() {
            Random random = new Random();
            int randomNumber = 0 + random.nextInt(root.size - 1);
            logger.info("{}", randomNumber);
            return getNode(root, randomNumber);
        }

        public Node getNode(Node currentNode, int nodeNumber) {
            if (currentNode == null) return null;
            if (currentNode.size == nodeNumber) return currentNode;
            int leftSize = currentNode.left == null ? 0 : currentNode.left.size;
            if (nodeNumber <= leftSize) return getNode(currentNode.left, nodeNumber);
            else return getNode(currentNode.right, nodeNumber - leftSize);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        int size = 1;

        public Node(int data) {
            this.data = data;
        }

        public Node left() {
            return left;
        }

        public void insertAsChild(Node node) {
            this.size++;
            if (node.data <= this.data) {
                if (left == null) left(node);
                else left.insertAsChild(node);
            } else {
                if (right == null) right(node);
                else right.insertAsChild(node);
            }
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

        public int size() {
            return this.size;
        }

        @Override
        public String toString() {
            return "" + data;
        }

        public String toDeepString() {
            return (left + " " + data + " " + right).replaceAll("null", "");
        }
    }
}
