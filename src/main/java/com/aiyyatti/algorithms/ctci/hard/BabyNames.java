package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * TODO: if you dont get the implementation of Graph right, you will never get this problem right.
 */
public class BabyNames {
    @Test
    public void ctciTest() {
        Node john = new Node("John", 15);
        Node jon = new Node("Jon", 15);
        Node chris = new Node("Chris", 15);
        Node kris = new Node("Kris", 15);
        Node christopher = new Node("Christopher", 15);
        LinkedList<Node> list = new LinkedList<>();
        list.add(john);
        list.add(jon);
        list.add(chris);
        list.add(kris);
        list.add(christopher);
        Graph graph = new Graph(list, new String[][]{
                new String[]{"Jon", "John"},
                new String[]{"John", "Johnny"},
                new String[]{"Chris", "Kris"},
                new String[]{"Chris", "Christopher"}
        });
        BabyNamesDS nameDS = new BabyNamesDS(graph);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Kris", 45);
        expected.put("Johnny", 30);
        Map<String, Integer> actual = nameDS.babyNames();
        for (String name : actual.keySet()) {
            System.out.println(name + " " + actual.get(name));
            TestCase.assertEquals(expected.get(name), actual.get(name));
        }
    }

    @Test
    public void ctci2Test() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node("John", 10));
        list.add(new Node("Jon", 3));
        list.add(new Node("Davis", 2));
        list.add(new Node("Kari", 3));
        list.add(new Node("Johnny", 11));
        list.add(new Node("Carlton", 8));
        list.add(new Node("Carleton", 2));
        list.add(new Node("Jonathan", 9));
        list.add(new Node("Carrie", 5));
        Graph graph = new Graph(list, new String[][]{
                new String[]{"Jonathan", "John"},
                new String[]{"Jon", "Johnny"},
                new String[]{"Johnny", "John"},
                new String[]{"Kari", "Carrie"},
                new String[]{"Carleton", "Carlton"}
        });
        BabyNamesDS nameDS = new BabyNamesDS(graph);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Johnny", 33);
        expected.put("Carrie", 8);
        expected.put("Davis", 2);
        expected.put("Carleton", 10);
        Map<String, Integer> actual = nameDS.babyNames();
        for (String name : actual.keySet()) {
            System.out.println(name + " " + actual.get(name));
            TestCase.assertEquals(expected.get(name), actual.get(name));
        }
    }

    class BabyNamesDS {
        Map<String, Boolean> visited = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Graph graph;

        public BabyNamesDS(Graph graph) {
            this.graph = graph;
            for (String name : graph.lookup.keySet()) {
                visited.put(name, false);
                parent.put(name, name);
            }
        }

        public HashMap<String, Integer> babyNames() {
            HashMap<String, Integer> root = new HashMap<>();
            for (String name : graph.lookup.keySet()) {
                if (!visited.get(name)) {
                    root.put(name, freqOf(name));
                }
            }
            return root;
        }

        public int freqOf(String name) {
            int freq = graph.node(name).freq;
            visited.put(name, true);
            for (String adjacent : graph.adjacents(name)) if (!visited.get(adjacent)) freq += freqOf(adjacent);

            return freq;
        }
    }

    class Graph {
        Map<String, Node> lookup = new HashMap<>();
        Map<String, LinkedList<String>> adjacents = new HashMap<>();

        Graph(LinkedList<Node> nodes, String[][] links) {
            for (Node node : nodes) {
                lookup.put(node.name, node);
                adjacents.put(node.name, new LinkedList<>());
            }
            for (String[] pair : links) {
                link(pair[0], pair[1]);
                link(pair[1], pair[0]);
            }
        }

        public void link(String side1, String side2) {
            LinkedList<String> list1 = null;
            if (null == (list1 = adjacents.get(side1))) {
                list1 = new LinkedList<>();
                adjacents.put(side1, list1);
            }
            if (null == lookup.get(side1)) {
                lookup.put(side1, new Node(side1, 0));
            }
            adjacents.get(side1).add(side2);
        }


        public Node node(String name) {
            return lookup.get(name);
        }

        public LinkedList<String> adjacents(String name) {
            return adjacents.get(name);
        }
    }

    class Node {
        String name;
        int freq;

        public Node(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }
    }
}
