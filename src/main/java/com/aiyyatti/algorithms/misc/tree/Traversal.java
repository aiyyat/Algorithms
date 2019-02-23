package com.aiyyatti.algorithms.misc.tree;

import com.aiyyatti.algorithms.common.tree.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

public class Traversal {
    /**
     * Time Complexity: O(n)
     *
     * @param root
     * @return
     */
    public String preOrder(TreeNode root) {
        if (root == null) return "";
        return root.dataStr() + " " + preOrder(root.left()) + preOrder(root.right());
    }

    /**
     * Time Complexity: O(n)
     *
     * @param root
     * @return
     */
    public String inOrder(TreeNode root) {
        if (root == null) return "";
        return inOrder(root.left()) + root.dataStr() + " " + inOrder(root.right());
    }

    /**
     * Time Complexity: O(n)
     *
     * @param root
     * @return
     */
    public String postOrder(TreeNode root) {
        if (root == null) return "";
        return postOrder(root.left()) + postOrder(root.right()) + root.dataStr() + " ";
    }

    @FunctionalInterface
    interface Trim {
        public String apply();
    }
    // Test cases
    public TreeNode simple() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        n1.right(n3);
        n1.left(n2);
        n2.left(n4);
        n2.right(n5);
        return n1;
    }
    @Test
    public void preOrderSimpleTest() {
        TestCase.assertEquals("1 2 4 5 3", preOrder(simple()));
    }

    @Test
    public void inOrderSimpleTest() {
        TestCase.assertEquals("4 2 5 1 3", inOrder(simple()));
    }

    @Test
    public void postOrderSimpleTest() {
        TestCase.assertEquals("4 5 2 3 1", postOrder(simple()));
    }
}
