package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public void ctciTest() {
        Node root = new NodeBuilder().add(0).add(1).add(2).add(1).add(0).build();
        assertTrue(isPalindromeWithStack(root));
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddWithOneNodeTest() {
        Node root = new NodeBuilder().add(0).build();
        assertTrue(isPalindromeWithStack(root));
        assertTrue(isPalindrome(root));
    }

    @Test
    public void evenPalindromeTest() {
        Node root = new NodeBuilder().add(0).add(0).build();
        assertTrue(isPalindromeWithStack(root));
        assertTrue(isPalindrome(root));
    }
    @Test
    public void nullNodeTest() {
        Node root = new NodeBuilder().add(0).add(0).build();
        assertTrue(isPalindromeWithStack(null));
        assertTrue(isPalindrome(null));
    }

    @Test
    public void evenNotPalindromeTest() {
        Node root = new NodeBuilder().add(0).add(1).build();
        assertFalse(isPalindromeWithStack(root));
        assertFalse(isPalindrome(root));
    }

    @Test
    public void oddMoreThanOneNodePalindromTest() {
        Node root = new NodeBuilder().add(0).add(1).add(0).build();
        assertTrue(isPalindromeWithStack(root));
        assertTrue(isPalindrome(root));
    }

    @Test
    public void oddMoreThanOneNodeNotPalindromTest() {
        Node root = new NodeBuilder().add(0).add(1).add(2).build();
        assertFalse(isPalindromeWithStack(root));
        assertFalse(isPalindrome(root));
    }

    /////////////////////
    // APPROACH I STACK//
    /////////////////////
    public boolean isPalindromeWithStack(Node root) {
        return isPalindromeWithStack(root, count(root));
    }

    public boolean isPalindromeWithStack(Node root, int total) {
        Stack<Integer> stack = new Stack<>();
        int count = 2;
        while (root != null) {
            if (total - count >= 0) {
                stack.push(root.data);
            } else if (total - count < -1) {
                if (stack.pop() != root.data) return false;
            }
            count += 2;
            root = root.next;
        }
        return true;
    }

    /////////////////////
    // APPROACH I STACK//
    /////////////////////
    public boolean isPalindrome(Node root) {
        return isPalindrome(root, count(root) - 2).result;
    }

    public Result isPalindrome(Node root, int position) {
        if (position > 0) {
            Result result = isPalindrome(root.next, position - 2);
            Node next = result.node.next;
            boolean outcome = result.result && (next.data == root.data);
            return new Result(outcome, next);
        } else if (position == 0) {
            return new Result(root.next, root.data == root.next.data);
        } else return new Result(true, root);
    }

    private int count(Node root) {
        Node current = root;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

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
