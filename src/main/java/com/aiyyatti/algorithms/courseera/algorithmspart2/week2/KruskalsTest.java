package com.aiyyatti.algorithms.courseera.algorithmspart2.week2;

import org.junit.Test;

public class KruskalsTest {
    @Test
    public void courseEraTest() {
        Edge[] Es = new Edge[17];
        Es[0] = new Edge(0, 7, 0.16);
        Es[1] = new Edge(2, 3, 0.17);
        Es[2] = new Edge(1, 7, 0.19);
        Es[3] = new Edge(0, 2, 0.26);
        Es[4] = new Edge(1, 3, 0.29);
        Es[5] = new Edge(1, 5, 0.32);
        Es[6] = new Edge(2, 7, 0.34);
        Es[7] = new Edge(4, 5, 0.35);
        Es[8] = new Edge(1, 2, 0.36);
        Es[9] = new Edge(4, 7, 0.37);
        Es[10] = new Edge(0, 4, 0.38);
        Es[11] = new Edge(6, 2, 0.40);
        Es[12] = new Edge(3, 6, 0.52);
        Es[13] = new Edge(6, 0, 0.58);
        Es[14] = new Edge(0, 4, 0.38);
        Es[15] = new Edge(6, 4, 0.93);
        Es[16] = new Edge(5, 7, 0.28);
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8, Es);
        Kruskals kruskals = new Kruskals(graph);
        System.out.println(kruskals.getMST());
    }
}
