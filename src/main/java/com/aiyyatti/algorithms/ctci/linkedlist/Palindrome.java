package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * TODO:
 * learn the Queue and Stack Implmentations in java.
 * CTCI had a cleaner implementation -
 * To know: what will the parameters to method be while
 * doing reverse recursion?? - the original values.
 * <p>
 * I implemented it wrong - ended up adding to Queue until middle element and
 * then returning and checking with polled value form Queue -
 * in the end checking the element with itself.
 * so if you are using recursion DO not use Queue.
 */
public class Palindrome {
    //////////////
    // TESTCASE //
    //////////////
    @Test
    public void ctciwithoutDSTest() {
        Node root = new NodeBuilder().add(0).add(1).add(2).add(1).add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddWithOneNodewithoutDSTest() {
        Node root = new NodeBuilder().add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void evenPalindromewithoutDSTest() {
        Node root = new NodeBuilder().add(0).add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void evenNotPalindromewithoutDSTest() {
        Node root = new NodeBuilder().add(0).add(1).build();
        assertFalse(isPalindrome(root));
    }

    @Test
    public void oddMoreThanOneNodePalindromwithoutDSTest() {
        Node root = new NodeBuilder().add(0).add(1).add(0).build();
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddMoreThanOneNodeNotPalindromwithoutDSTest() {
        Node root = new NodeBuilder().add(0).add(1).add(2).build();
        assertFalse(isPalindrome(root));
    }

    ////////////////
    // APPROACH I //
    ////////////////
    class Result {
        boolean result;
        Node node;

        public Result(Node node, boolean result) {
            this.result = result;
            this.node = node;
        }

        public Result(boolean result, Node node) {
            this.node = node;
            this.result = result;
        }
    }

    //corner - root is null
    public boolean isPalindrome(Node root) {
        int count = 0;
        Node head = root;
        while (head != null) {
            count++;
            head = head.next;
        }
        return isPalindrome(root, count - 2).result;
    }

    public Result isPalindrome(Node root, int position) {
        // two element case explicitly and even number of 2+ element case.
        if (position == 0) return new Result(root, root.data == root.next.data);
        else if (position == -1) return new Result(root.next, true);
        else if (position > 0) {
            Result m = isPalindrome(root.next(), position - 2);
            if (!m.result || root.data != m.node.data) return new Result(false, null);
            else return new Result(true, m.node.next);
        } else return new Result(null, false);
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
