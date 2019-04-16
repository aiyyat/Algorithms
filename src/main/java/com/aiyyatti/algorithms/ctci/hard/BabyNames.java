package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BabyNames {
    @Test
    public void ctciTest() {
        Graph graph = new Graph();
        graph.add("John", 15);
        graph.add("Jon", 12);
        graph.add("Chris", 13);
        graph.add("Kris", 4);
        graph.add("Christopher", 19);
        graph.link("Jon", "John");
        graph.link("John", "Johnny");
        graph.link("Chris", "Kris");
        graph.link("Chris", "Christopher");
        NameGraph nameGraph = new NameGraph(graph);
        System.out.println(nameGraph.rootNames());
    }

    class NameGraph {
        Graph graph;

        NameGraph(Graph graph) {
            this.graph = graph;
            for (String name : graph.names()) {
                meta.put(name, new Metadata(name, 0, false));
            }
        }

        class Metadata {
            String name;
            Integer frequency;
            boolean visited;
            String parent;

            public Metadata(String name, Integer frequency, boolean visited) {
                this.name = name;
                this.frequency = frequency;
                this.visited = visited;
            }

            public void visited() {
                this.visited = true;
            }
        }

        public HashMap<String, Integer> rootNames() {
            HashMap<String, Integer> rootNames = new HashMap<>();
            for (String name : meta.keySet()) {
                if (!meta.get(name).visited) {
                    Metadata metadata = visit(name);
                    rootNames.put(name, metadata.frequency);
                }
            }
            return rootNames;
        }

        Map<String, Metadata> meta = new HashMap<>();

        public Metadata visit(String name) {
            Metadata data = meta.get(name);
            for (String neighbour : graph.names()) {
                if (!meta.get(name).visited) {
                    data.visited();
                    data.frequency = graph.node(name).freq + visit(neighbour).frequency;
                }
            }
            return data;
        }
    }

    class Graph {
        Map<String, Node> lookup = new HashMap<>();

        public Set<String> names() {
            return lookup.keySet();
        }

        public Node node(String name) {
            return lookup.get(name);
        }

        public void link(String name1, String name2) {
            Node node2 = lookup.get(name2);
            Node node1 = lookup.get(name2);
            if (node2 == null) lookup.put(name2, node2 = new Node(name1, 0));
            if (node1 == null) lookup.put(name1, node1 = new Node(name1, 0));
            node2.addNeighbour(node1);
        }

        public void add(String name, Integer freq) {
            lookup.put(name, new Node(name, freq));
        }
    }

    class Node {
        private String name;
        private Integer freq = 0;
        private HashSet<Node> neighbours = new HashSet<>();

        public Node(String name, Integer freq) {
            this.name = name;
            this.freq = freq;
        }

        public Node(String name) {
            this.name = name;
        }

        public HashSet<Node> children() {
            return neighbours;
        }

        public void children(HashSet<Node> children) {
            this.neighbours = children;
        }

        public void addNeighbour(Node child) {
            if (!neighbours.contains(child)) {
                this.neighbours.add(child);
                child.addNeighbour(this);
            }
        }
    }
}
