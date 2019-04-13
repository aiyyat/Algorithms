package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.TestCase.assertTrue;

/**
 * TODO: learn the Queue and Stack Implmentations in java.
 */
public class Palindrome {
    @Test
    public void ctciTest() {
        Node root = new NodeBuilder().add(0).add(1).add(2).add(1).add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddWithOneNodeTest() {
        Node root = new NodeBuilder().add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void evenPalindromeTest() {
        Node root = new NodeBuilder().add(0).add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void evenNotPalindromeTest() {
        Node root = new NodeBuilder().add(0).add(1).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddMoreThanOneNodePalindromTest() {
        Node root = new NodeBuilder().add(0).add(1).add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddMoreThanOneNodeNotPalindromTest() {
        Node root = new NodeBuilder().add(0).add(1).add(2).build();
        assertTrue(isPalindrome(root));
    }

    public boolean isPalindrome(Node root) {
        return isPalindrome(root, root, new LinkedList<Node>());
    }

    public boolean isPalindrome(Node root, Node runner, Queue<Node> queue) {
        if (root == null) return true;
        if (runner != null) {
            queue.add(runner);
            runner = runner.next == null ? null : runner.next.next;
        }
        boolean result = isPalindrome(root.next, runner, queue);
        if (queue.isEmpty()) return result;
        else return result || queue.poll().data == root.data;
    }

    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void next(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    class NodeBuilder {
        Node root;
        Node next;

        public NodeBuilder add(Node node) {
            if (root == null) root = next = node;
            else {
                next.next = node;
                next = node;
            }
            return this;
        }

        public NodeBuilder add(Integer data) {
            return add(new Node(data));
        }

        public Node build() {
            return root;
        }
    }
}
