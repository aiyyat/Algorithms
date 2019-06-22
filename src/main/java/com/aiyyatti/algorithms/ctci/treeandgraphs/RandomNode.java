package com.aiyyatti.algorithms.ctci.treeandgraphs;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;

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
        Node n5 = new Node(5);
        Tree tree = new Tree(n5);
        tree.insertInOrder(3);
        tree.insertInOrder(7);
        tree.insertInOrder(2);
        tree.insertInOrder(1);
        tree.insertInOrder(4);
        tree.insertInOrder(6);
        tree.insertInOrder(8);
        tree.insertInOrder(9);
        for (int i = 1; i <= 9; i++) assertEquals(i, tree.getNode(n5, i).data);
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void insertInOrder(int node) {
            insertInOrder(root, node);
        }

        public Node insertInOrder(Node root, int data) {
            if (root == null) return new Node(data);
            else {
                if (data < root.data) {
                    root.size++;
                    root.left = insertInOrder(root.left, data);
                } else root.right = insertInOrder(root.right, data);
                return root;
            }
        }

        public Node getRandomNode() {
            Random random = new Random();
            int randomNumber = random.nextInt(root.size - 1);
            return getNode(root, randomNumber);
        }

        public Node getNode(Node root, int random) {
            if (random == root.size) return root;
            else if (random <= root.size) return getNode(root.left, random);
            else return getNode(root.right, random - root.size);
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
