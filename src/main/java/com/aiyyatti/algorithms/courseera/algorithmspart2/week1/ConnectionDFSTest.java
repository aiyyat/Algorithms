package com.aiyyatti.algorithms.courseera.algorithmspart2.week1;

import junit.framework.TestCase;
import org.junit.Test;

public class ConnectionDFSTest {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        int[][] Es = new int[][]{
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3},
                new int[]{3, 4}, new int[]{0, 5}, new int[]{5, 6},
                new int[]{6, 7}, new int[]{7, 4}, new int[]{8, 9},
                new int[]{9, 10}, new int[]{10, 11}, new int[]{8, 11}
        };
        Graph graph = new Graph(12, Es);
        TestCase.assertEquals("0 1 2 3 4", new ConnectionDFS(graph).getConnectionPath(0, 4).toString());
        TestCase.assertEquals("0 1 2 3 4 7", new ConnectionDFS(graph).getConnectionPath(0, 7).toString());
        TestCase.assertNull(new ConnectionDFS(graph).getConnectionPath(0, 11));
    }
}
