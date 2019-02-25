package com.aiyyatti.algorithms.ctci.treesandgraphs;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Question:
 * Route Between Nodes: Given a directed graph, design an algorithm
 * to find out whether there is a route between two nodes.
 */
public class RoutesBetweenNodes {
    public boolean isConnected(DiGraph graph, Vertex start, Vertex end) {
        boolean found = false;
        for (Vertex vertex : graph.edges(start)) {
            if (found) {
                return found;
            } else if (!vertex.isVisited()) {
                vertex.markVisited();
                if (vertex == end) {
                    return true;
                } else {
                    found |= isConnected(graph, vertex, end);
                }
            }
        }
        return found;
    }

    ////////////////////
    // DATA STRUCTURE //
    ////////////////////

    /**
     * Design:
     * Ideally visited shouldn't be a property of the vertex.
     * However for a time bound interview one is better off presenting a simple solution
     * for easy explanation.
     * <p>
     * Mention:
     * It's always better to separate out the data structure from any specific functionality.
     * This way the data structure can evolve independent of the implementation and
     * can be used to solve a variety of problems.
     */
    class Vertex {
        private int data;
        private boolean visited;

        public int data() {
            return data;
        }

        public Vertex(int data) {
            this.data = data;
        }

        public void markVisited() {
            visited = true;
        }

        public boolean isVisited() {
            return visited;
        }

        @Override
        public String toString() {
            return " " + data;
        }
    }

    class DiGraph {
        private Map<Vertex, LinkedList<Vertex>> edges = new HashMap<>();

        public void edge(Vertex start, Vertex end) {
            if (!edges.containsKey(start)) {
                LinkedList<Vertex> startChildren = new LinkedList<>();
                edges.put(start, startChildren);
                startChildren.add(end);
            } else {
                edges.get(start).add(end);
            }
        }

        public Set<Vertex> vertices() {
            return edges.keySet();
        }

        public List<Vertex> edges(Vertex start) {
            LinkedList<Vertex> vertices = edges.get(start);
            return vertices == null ? Collections.EMPTY_LIST : vertices;
        }
    }

    ////////////////
    // TEST CASES //
    ////////////////
    Vertex v0 = new Vertex(0);
    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);
    Vertex v3 = new Vertex(3);
    Vertex v4 = new Vertex(4);
    Vertex v5 = new Vertex(5);
    Vertex v6 = new Vertex(6);
    Vertex v7 = new Vertex(7);
    Vertex v8 = new Vertex(8);
    Vertex v9 = new Vertex(9);
    DiGraph graph = null;

    @Before
    public void init() {
        graph = new DiGraph();
        graph.edge(v1, v2);
        graph.edge(v1, v3);
        graph.edge(v4, v5);
        graph.edge(v4, v0);
        graph.edge(v4, v5);
        graph.edge(v5, v6);
        graph.edge(v0, v6);
        graph.edge(v3, v9);
        graph.edge(v3, v7);
        graph.edge(v9, v7);
        graph.edge(v7, v8);
        graph.edge(v8, v6);
    }

    @Test
    public void connectedSimple() {
        TestCase.assertTrue(isConnected(graph, v1, v6));
    }

    @Test
    public void notConnectedSimple() {
        TestCase.assertFalse(isConnected(graph, v6, v1));
    }
}
