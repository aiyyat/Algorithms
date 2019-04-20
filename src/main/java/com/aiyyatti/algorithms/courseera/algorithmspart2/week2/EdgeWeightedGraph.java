package com.aiyyatti.algorithms.courseera.algorithmspart2.week2;

import java.util.ArrayList;
import java.util.Arrays;

public class EdgeWeightedGraph {
    int V, E;
    Edge edges[];
    ArrayList<Edge>[] Es = null;

    public EdgeWeightedGraph(int V, Edge edges[]) {
        this.V = V;
        this.edges = edges;
        Es = new ArrayList[V];
        Arrays.fill(Es, new ArrayList<Edge>());
        for (Edge e : edges) {
            Es[e.v].add(e);
            Es[e.w].add(e);
        }
    }

    public ArrayList<Edge> adjacent(int v) {
        return Es[v];
    }
}

class Edge implements Comparable<Edge> {
    int v, w;
    double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (this.v == vertex) return w;
        return v;
    }

    public int compareTo(Edge e) {
        return Double.valueOf(this.weight).compareTo(e.weight);
    }

    @Override
    public String toString() {
        return v + "->" + weight + "<-" + w + " ";
    }
}
