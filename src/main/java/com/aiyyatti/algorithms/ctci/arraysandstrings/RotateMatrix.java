package com.aiyyatti.algorithms.ctci.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * TODO: implementation is very tricky.
 * Things to remember:
 * 1) Approach the problem with a 5*5 matrix. this is to test the edge cases of (1) inner layer (2) single middle element.
 * 2) Represent each edge with a number this way you can recheck individual edge rotation
 * 3) Rotation transformation (or movement of each element of that group) the order is important.
 * 4) after each edge rotation "RECHECK" it with a value of the inner matrix.
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
        int N = a.length - 1;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i; j++) {
                // 2 => temp
                int temp = a[N - j][N - i];
                // 1 => 2
                a[N - j][N - i] = a[i][N - j];
                // 4 => 1
                a[i][N - j] = a[j][i];
                // 3 => 4
                a[j][i] = a[N - i][j];
                // temp => 3
                a[N - i][j] = temp;
            }
        }
    }
}
