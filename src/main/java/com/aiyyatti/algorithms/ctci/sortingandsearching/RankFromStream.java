package com.aiyyatti.algorithms.ctci.sortingandsearching;

import org.junit.Test;

public class RankFromStream {
    @Test
    public void simpleTest() {
        Ranker ranker = new Ranker();
        ranker.track(5);
        ranker.track(1);
        ranker.track(4);
        ranker.track(4);
        ranker.track(5);
        ranker.track(9);
        ranker.track(7);
        ranker.track(13);
        ranker.track(3);
        System.out.println(ranker.getRankOfNumber(1));
        System.out.println(ranker.getRankOfNumber(3));
        System.out.println(ranker.getRankOfNumber(4));
    }

    class Ranker {
        Node root;

        public void track(int x) {
            root = track(root, x, -1);
        }

        public int getRankOfNumber(int x) {
            return getRankOfNumber(root, x);
        }

        public Node track(Node root, int x, int carry) {
            if (root == null) {
                Node node = new Node(x, null, null);
                node.incrRank(carry + 1);
                return node;
            }
            if (root.data == x) return root;
            else if (x < root.data) {
                root.incrRank();
                root.left = track(root.left, x, carry);
            } else root.right = track(root.right, x, root.rank);
            return root;
        }

        public int getRankOfNumber(Node root, int x) {
            if (root == null) return -1;
            if (root.data == x) return root.rank;
            else if (x < root.data) return getRankOfNumber(root.left, x);
            else return getRankOfNumber(root.right, x);
        }
    }

    class Node {
        int data;
        int rank;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void incrRank(int i) {
            rank += i;
        }

        public void incrRank() {
            incrRank(1);
        }
    }
}
