package com.aiyyatti.algorithms.ctci.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * TODO: use a do while instead of a while to skip the first node check.
 */
public class LoopDetection {
    @Test
    public void ctciTest() {
        Node c = new Node('C');
        NodeBuilder nb = new NodeBuilder().add('A').add('B').add(c).add('D').add('E').add(c);
        assertEquals(c, doLoopDetection(nb.build()));
    }

    @Test
    public void noCommonTest() {
        NodeBuilder nb = new NodeBuilder().add('A').add('B').add('C').add('D').add('E').add('F');
        assertNull(doLoopDetection(nb.build()));
    }

    public Node doLoopDetection(Node root) {
        Node runner = root, ptr = root;
        do {
            if (runner == null || runner.next == null) return null;
            runner = runner.next.next;
            ptr = ptr.next;
        } while (runner != ptr);
        ptr = root;
        while (runner != ptr) {
            runner = runner.next;
            ptr = ptr.next;
        }
        return ptr;
    }

    class Node {
        Node next;
        Character data;

        public Node(Character data) {
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

        public NodeBuilder add(Character data) {
            return add(new Node(data));
        }

        public Node build() {
            return root;
        }
    }
}
