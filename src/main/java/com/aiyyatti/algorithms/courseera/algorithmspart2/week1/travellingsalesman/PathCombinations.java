package com.aiyyatti.algorithms.courseera.algorithmspart2.week1.travellingsalesman;

import com.aiyyatti.algorithms.courseera.algorithmspart2.week1.Graph;
import org.junit.Test;

import java.util.Stack;

public class PathCombinations {
    @Test
    public void fourNodeTest() {
        Graph graph = new Graph(10, new int[][]{
                new int[]{0, 1},
                new int[]{1, 3},
                new int[]{3, 2},
                new int[]{3, 4},
                new int[]{2, 4},
                new int[]{1, 2},
                new int[]{5, 6},
                new int[]{6, 7},
                new int[]{7, 8},
                new int[]{9, 8},
                new int[]{7, 5},
                new int[]{2, 4},
                new int[]{9, 2},
                new int[]{1, 3},
                new int[]{4, 5},
                new int[]{6, 4},
                new int[]{4, 1}
        });
        int startingAt = 0;
        visited.add(startingAt);
        printPathCombinations(graph, startingAt);
    }

    Stack<Integer> visited = new Stack<>();

    public void printPathCombinations(Graph graph, int startingAt) {
        if (visited.size() == graph.V()) System.out.println(visited);
        for (int i : graph.neighboursOf(startingAt)) {
            if (!visited.contains(i)) {
                visited.push(i);
                printPathCombinations(graph, i);
                visited.pop();
            }
        }
    }
}
