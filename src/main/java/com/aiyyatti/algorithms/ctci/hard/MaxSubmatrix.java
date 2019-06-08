package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

import java.util.Arrays;

public class MaxSubmatrix {
    boolean isDebug = true;

    @Test
    public void testCtci() {
        int a[][] = new int[][]{
                new int[]{-9, -7, 8},
                new int[]{-3, 7, 6},
                new int[]{-6, 1, 4}
        };
        System.out.println(doMaxSubmatrix(a));
    }

    @Test
    public void testMaxSubmatrix() {
        int a[][] = new int[][]{
                new int[]{-1, 3, 2, 6, 2, 1 - 5},
                new int[]{-5, 2, 6, -7, 8, 3, 6},
                new int[]{-5, -3, -7, -9, -2, -6, -8},
                new int[]{1, 7, 3, 1, -9, 2, 1},
                new int[]{3, 2, -7, -1, 6, -8, 4},
                new int[]{-5, -7, -2, 1, 8, 2, -1},
        };
        System.out.println(doMaxSubmatrix(a));
    }

    /**
     * brute force is when not doing Kadanes. the TC goes to O(N^4) else its O(N^3)
     *
     * @param a
     * @return
     */
    public int doMaxSubmatrix(int[][] a) {
        int N = a.length;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < N; index++) {
            int sum[] = new int[N];
            for (int row = index; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    sum[column] += a[row][column];
                }
                max = Math.max(max, doKadanes(sum));
                if (isDebug) {
                    System.out.printf("found a new max %s at (rows:%s to rows:%s) Array:%s \n", max, index, row, Arrays.toString(sum));
                }
            }
        }
        return max;
    }

    public int doKadanes(int[] a) {
        int N = a.length;
        int sum = a[0];
        int max = sum;
        for (int i = 1; i < N; i++) {
            sum = Math.max(sum + a[i], a[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}