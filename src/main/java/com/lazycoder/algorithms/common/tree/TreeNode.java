package com.lazycoder.algorithms.common.tree;

import org.junit.Test;

import java.text.MessageFormat;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this(data);
        this.left = left;
        this.right = right;
    }

    // Use instead of standard accessors to make it more precise
    public void left(TreeNode left) {
        this.left = left;
    }

    public void right(TreeNode right) {
        this.right = right;
    }

    public TreeNode left() {
        return this.left;
    }

    public TreeNode right() {
        return this.right;
    }

    public int data() {
        return data;
    }

    public String dataStr() {
        return "" + data;
    }

    @Override
    public String toString() {
        return "" + data;
    }

    public String toTreeString() {
        return "";
    }

    @Test
    public void printSimple() {
        TreeNode n1 = new TreeNode(5, new TreeNode(4), new TreeNode(6));
        System.out.println(n1.toTreeString());
    }
}
