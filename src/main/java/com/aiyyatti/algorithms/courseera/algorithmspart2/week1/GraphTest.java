package com.aiyyatti.algorithms.courseera.algorithmspart2.week1;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class GraphTest {
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
        Graph graph;
        graph = new Graph(new ByteArrayInputStream(str.getBytes()));
        ArrayList<Integer> neighbours = graph.neighboursOf(6);
        TestCase.assertEquals(3, neighbours.size());
        TestCase.assertTrue(neighbours.contains(4));
        TestCase.assertTrue(neighbours.contains(8));
        TestCase.assertTrue(neighbours.contains(5));
    }
}