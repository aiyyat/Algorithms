package com.aiyyatti.algorithms.graph.ctci;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm
 * to find out whether there is a route between two nodes.
 *
 * FIXME
 *  Do not try to implement a Separate DS for Graph which is generic in nature.
 *  Just mention that it could be implemented that way during an interview.
 */
public class RoutesBetweenNodes {
    /**
     * DFS without queues
     * Time Complexity: O(V+E)
     *
     * @param graph
     * @param start
     * @param end
     * @return
     */
    public boolean isDFSConnected(DiGraph graph, Vertex start, Vertex end) {
        if (start == end) {
            return true;
        }
        boolean found = false;
        for (Vertex vertex : graph.getEdges(start)) {
            if (found) {
                return found;
            } else if (!vertex.isVisited()) {
                vertex.markVisited();
                found |= isDFSConnected(graph, vertex, end);
            }
        }
        return found;
    }

    /**
     * BFS
     * Time Complexity: O(V+E)
     *
     * @param graph
     * @param start
     * @param end
     * @return
     */
    public boolean isBFSConnected(DiGraph graph, Vertex start, Vertex end) {
        Queue<Vertex> queue = new LinkedList<>();
        ((LinkedList<Vertex>) queue).add(start);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (vertex == end) {
                return true;
            }
            queue.addAll(graph.getEdges(vertex));
        }
        return false;
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

        public void addEdge(Vertex start, Vertex end) {
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

        public List<Vertex> getEdges(Vertex start) {
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
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v4, v5);
        graph.addEdge(v4, v0);
        graph.addEdge(v4, v5);
        graph.addEdge(v5, v6);
        graph.addEdge(v0, v6);
        graph.addEdge(v3, v9);
        graph.addEdge(v3, v7);
        graph.addEdge(v9, v7);
        graph.addEdge(v7, v8);
        graph.addEdge(v8, v6);
    }

    @Test
    public void connectedSimpleDFS() {
        TestCase.assertTrue(isDFSConnected(graph, v1, v6));
    }

    @Test
    public void notConnectedSimpleDFS() {
        TestCase.assertFalse(isDFSConnected(graph, v6, v1));
    }

    @Test
    public void connectedSimpleBFS() {
        TestCase.assertTrue(isDFSConnected(graph, v1, v6));
    }

    @Test
    public void notConnectedSimpleBFS() {
        TestCase.assertFalse(isDFSConnected(graph, v6, v1));
    }
}
