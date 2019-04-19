package com.aiyyatti.algorithms.courseera.algorithmspart2.week1;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.coursera.org/learn/algorithms-part2/lecture/4ZE6G/graph-api
 */
@RunWith(Enclosed.class)
public class Graph {
    int V;
    int E;
    ArrayList<Integer>[] vs = null;

    /**
     * Follow the format
     * number of
     *
     * @param is
     */
    public Graph(InputStream is) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(is);
            this.V = scanner.nextInt();
            vs = new ArrayList[V];
            this.E = scanner.nextInt();
            for (int i = 0; i < E; i++) addEdge(scanner.nextInt(), scanner.nextInt());
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                scanner.close();
                is.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Graph(int V, int[][] Es) {
        this.V = V;
        vs = new ArrayList[V];
        this.E = E;
        for (int[] E : Es) addEdge(E[0], E[1]);
    }

    public ArrayList<Integer> neighboursOf(int v) {
        return vs[v];
    }

    public void addEdge(int v1, int v2) {
        addDirectionalEdge(v1, v2);
        addDirectionalEdge(v2, v1);
    }

    private void addDirectionalEdge(int v1, int v2) {
        if (vs[v1] == null) vs[v1] = new ArrayList<>();
        vs[v1].add(v2);
    }

    public class GraphTester {
        @Test
        public void simpleTest() {
            String str = "9\n" +
                    "10\n" +
                    "0 1\n" +
                    "1 2\n" +
                    "1 3\n" +
                    "2 4\n" +
                    "4 6\n" +
                    "3 7\n" +
                    "7 8\n" +
                    "6 8\n" +
                    "4 5\n" +
                    "5 6";
            Graph graph = new Graph(new ByteArrayInputStream(str.getBytes()));
            ArrayList<Integer> neighbours = graph.neighboursOf(6);
            TestCase.assertEquals(3, neighbours.size());
            TestCase.assertTrue(neighbours.contains(4));
            TestCase.assertTrue(neighbours.contains(8));
            TestCase.assertTrue(neighbours.contains(5));
        }
    }
}

