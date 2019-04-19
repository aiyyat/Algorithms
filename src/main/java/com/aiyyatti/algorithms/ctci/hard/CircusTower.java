package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CircusTower {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest1() {
        int[][] persons = new int[][]{new int[]{65, 100}, new int[]{70, 150}, new int[]{56, 90}, new int[]{75, 190}, new int[]{60, 95}, new int[]{68, 22}};
        TestCase.assertEquals("[68, 22][70, 150]", asString(doCircusTower(persons)));
    }

    @Test
    public void simpleTest2() {
        int[][] persons = new int[][]{new int[]{40, 70}, new int[]{70, 40}};
        TestCase.assertEquals("[40, 70]", asString(doCircusTower(persons)));
    }

    @Test
    public void simpleTest3() {
        int[][] persons = new int[][]{new int[]{40, 70}};
        TestCase.assertEquals("[40, 70]", asString(doCircusTower(persons)));
    }

    @Test
    public void simpleTest4() {
        int[][] persons = new int[][]{new int[]{30, 50}, new int[]{50, 40}, new int[]{40, 30}};
        TestCase.assertEquals("[30, 50]", asString(doCircusTower(persons)));
    }

    @Test
    public void simpleTest5() {
        int[][] persons = new int[][]{new int[]{70, 70}, new int[]{40, 40}};
        TestCase.assertEquals("[40, 40]", asString(doCircusTower(persons)));
    }

    private String asString(int[][] a) {
        return Arrays.stream(a).map(val -> Arrays.toString(val)).collect(Collectors.joining(""));
    }


    public int[][] doCircusTower(int[][] input) {
        int[][] a = input.clone();
        Arrays.sort(a, (p1, p2) -> p1[0] - p2[0]);
        int max = Integer.MIN_VALUE;
        int start = 0, end = 1;
        int localStart = 0;
        int localMax = input[0][1];
        int N = input.length;
        for (int i = 1; i < N; i++) {
            if (a[i - 1][1] > a[i][1] || i == N - 1) {
                if (localMax > max) {
                    max = localMax;
                    start = localStart;
                    localStart = i;
                    end = i;
                }
            } else localMax++;
        }
        return Arrays.copyOfRange(a, start, end);
    }
}
