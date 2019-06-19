package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;

import static java.lang.Math.max;
import static junit.framework.TestCase.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class MaxSubmatrix {
    private static final Logger logger = getLogger(MaxSubmatrix.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, -1, -3, 4},
                new int[]{-2, -1, 3, -2, 2},
                new int[]{1, -1, -2, 5, 3},
                new int[]{2, -1, 1, -2, 3}
        };
        assertEquals(12, doMaxSubmatrix(matrix));
    }

    //////////////
    // SOLUTION //
    //////////////
    public int doMaxSubmatrix(int[][] a) {
        int returnSum = Integer.MIN_VALUE;
        int rowN = a.length;
        int colN = a[0].length;
        System.out.println(rowN + "::" + colN);
        for (int i = 0; i < rowN; i++) {
            for (int j = i; j < rowN; j++) {
                int[] sum = new int[colN];
                for (int k = i; k <= j; k++) {
                    for (int col = 0; col < colN; col++) {
                        sum[col] += a[k][col];
                    }
                }
                int maxSum = sum[0];
                int localSum = sum[0];
                for (int col = 1; col < colN; col++) {
                    localSum = max(localSum + sum[col], sum[col]);
                    maxSum = max(maxSum, localSum);
                }
                returnSum = max(returnSum, maxSum);
                System.out.printf("%s to %s , %s -> %s\n", i, j, Arrays.toString(sum), returnSum);
            }
        }
        return returnSum;
    }
}
