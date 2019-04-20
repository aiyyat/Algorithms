package com.aiyyatti.algorithms.courseera.algorithmspart2.week2;

import org.junit.Test;

import java.util.*;

/**
 * https://www.coursera.org/learn/algorithms-part2/lecture/KMCRd/kruskals-algorithm
 * used to find the Minimum Spanning Tree
 */
public class Kruskals {
    Queue<Edge> queue = new PriorityQueue<Edge>((e1, e2) -> Double.valueOf(e1.weight).compareTo(e2.weight));
    EdgeWeightedGraph graph;

    Kruskals(EdgeWeightedGraph graph) {
        this.graph = graph;
        queue.addAll(Arrays.asList(graph.edges));
    }

    public ArrayList<Edge> getMST() {
        UnionFind uf = new UnionFind(graph.V);
        ArrayList<Edge> output = new ArrayList<>();
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (!uf.isConnected(edge.v, edge.w)) {
                output.add(edge);
                uf.union(edge.v, edge.w);
            }
        }
        return output;
    }

    class UnionFind {
        int N;
        int[] a;

        UnionFind(int N) {
            this.N = N;
            a = new int[N];
            for (int i = 0; i < N; i++) a[i] = i;
        }

        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            a[root(p)] = root(q);
        }

        public int root(int p) {
            while (a[p] != p) {
                p = a[p];
            }
            return p;
        }
    }
}
