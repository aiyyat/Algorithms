package com.aiyyatti.algorithms.hackerrank.java;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int sum;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
       //do nothing
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class FancyVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

public class JavaVisitorPattern {
    public static Tree solve() {
        TreeNode t4 = new TreeNode(4,Color.RED,4);
        TreeNode t2 = new TreeNode(2,Color.RED,2);
        TreeLeaf t5 = new TreeLeaf(5,Color.RED,5);
        TreeLeaf t7 = new TreeLeaf(7,Color.GREEN,7);
        TreeLeaf t12 = new TreeLeaf(12,Color.GREEN,12);
        t4.addChild(t7);
        t4.addChild(t2);
        t2.addChild(t5);
        t4.addChild(t12);
        return t4;

//        String str = "5\n" +
//                "4 7 2 5 12\n" +
//                "0 1 0 0 1\n" +
//                "1 2\n" +
//                "1 3\n" +
//                "3 4\n" +
//                "3 5";
//        Scanner scanner = new Scanner(new ByteArrayInputStream(str.getBytes()));
//        int n = scanner.nextInt();
//        int[] values = new int[n];
//        for (int i = 0; i < n; i++) {
//            values[i] = scanner.nextInt();
//        }
//        Color[] color = new Color[n];
//        for (int i = 0; i < n; i++) {
//            color[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
//        }
//        int[] associations = new int[n];
//        for (int i = 0; i < n; i++) associations[i] = i + 1;
//        String association = "";
//        while ((association = scanner.next()) != "") {
//            String[] split = association.split(" ");
//            associations[Integer.valueOf(split[1])] = Integer.valueOf(split[0]);
//        }
//        Tree tree = new TreeNode(values[0], color[0], 1);
//        for(int i=0;i<associations.length;i++) {
//
//        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
//        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
//        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
//        root.accept(vis2);
//        root.accept(vis3);

        int res1 = vis1.getResult();
//        int res2 = vis2.getResult();
//        int res3 = vis3.getResult();

        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
    }
}