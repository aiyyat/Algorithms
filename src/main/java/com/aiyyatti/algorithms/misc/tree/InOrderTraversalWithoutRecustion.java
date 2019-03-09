package com.aiyyatti.algorithms.misc.tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

/**
 * InOrder Traversal without Recursion
 */
public class InOrderTraversalWithoutRecustion {
    /**
     * Follow the below rules:
     * 0) add the root node into the stack
     * 1) until stack is empty - peek the top of the node, if the node has a left node
     * keep adding it and left child to a stack until it hits a null.
     * 2) when it encounters a null pop until the next non null element and the print it
     * then add the right node and repeat (1).
     *
     * @return
     */
    private String doInOrderTraversalWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        StringBuilder output = new StringBuilder("");
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node == null) {
                stack.pop();
                if (!stack.isEmpty()) {
                    Node prevToThat = stack.pop();
                    output.append(prevToThat + " ");
                    stack.push(prevToThat.right);
                }
            } else stack.push(node.left);
        }
        return output.toString();
    }

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n0.left(n1);
        n0.right(n5);
        n1.left(n2);
        n1.right(n3);
        n3.right(n4);
        n0.right(n5);
        n5.left(n6);
        n5.right(n7);
        TestCase.assertEquals(inOrder(n0), doInOrderTraversalWithoutRecursion(n0));
    }

    public String inOrder(Node root) {
        if (root == null) return "";
        return inOrder(root.left()) + root.data + " " + inOrder(root.right());
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////
    class Node {
        Node left;
        Node right;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }

        public Node left() {
            return left;
        }

        public Node right() {
            return right;
        }

        public void left(Node left) {
            this.left = left;
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
