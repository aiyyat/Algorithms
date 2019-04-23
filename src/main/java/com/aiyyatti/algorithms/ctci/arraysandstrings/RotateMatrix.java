package com.aiyyatti.algorithms.ctci.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * TODO: very tricky problem. tip: do not use start and end. atleast dont precalculate end or the offset will be included twice.
 */
public class RotateMatrix {
    @Test
    public void simpleTest() {
        int[][] matrix = new int[][]{
                new int[]{0, 1, 2, 3, 4},
                new int[]{5, 6, 7, 8, 9},
                new int[]{10, 11, 12, 13, 14},
                new int[]{15, 16, 17, 18, 19},
                new int[]{20, 21, 22, 23, 24}
        };
        rotate(matrix);
        String expected = "[20, 15, 10, 5, 0]\n" +
                "[21, 16, 11, 6, 1]\n" +
                "[22, 17, 12, 7, 2]\n" +
                "[23, 18, 13, 8, 3]\n" +
                "[24, 19, 14, 9, 4]";
        // Use Assert.assertArrayEquals() instead.
        TestCase.assertEquals(expected, Arrays.stream(matrix).map(e -> Arrays.toString(e)).collect(Collectors.joining("\n")));
    }

    @Test
    public void simpleTest3() {
        int[][] matrix = new int[][]{
                new int[]{0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1},
                new int[]{2, 2, 2, 2, 2},
                new int[]{3, 3, 3, 3, 3},
                new int[]{4, 4, 4, 4, 4}
        };
        rotate(matrix);
        String expected = "[4, 3, 2, 1, 0]\n" +
                "[4, 3, 2, 1, 0]\n" +
                "[4, 3, 2, 1, 0]\n" +
                "[4, 3, 2, 1, 0]\n" +
                "[4, 3, 2, 1, 0]";
        // Use Assert.assertArrayEquals() instead.
        TestCase.assertEquals(expected, Arrays.stream(matrix).map(e -> Arrays.toString(e)).collect(Collectors.joining("\n")));
    }

    @Test
    public void simpleTest2() {
        int[][] matrix = new int[][]{
                new int[]{6, 7, 8},
                new int[]{11, 12, 13},
                new int[]{16, 17, 18}
        };
        rotate(matrix);
        String expected = "[16, 11, 6]\n" +
                "[17, 12, 7]\n" +
                "[18, 13, 8]";
        // Use Assert.assertArrayEquals() instead.
        TestCase.assertEquals(expected, Arrays.stream(matrix).map(e -> Arrays.toString(e)).collect(Collectors.joining("\n")));
    }

    public void rotate(int[][] a) {
        int N = a.length;
        for (int start = 0; start < N / 2; start++) {
            for (int i = start; i < N - 1 - start; i++) {
                int temp = a[start][i];
                a[start][i] = a[N - 1 - i][start];
                a[N - 1 - i][start] = a[N - 1 - start][N - 1 - i];
                a[N - 1 - start][N - 1 - i] = a[i][N - 1 - start];
                a[i][N - 1 - start] = temp;
            }
        }
    }
}
