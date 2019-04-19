package com.aiyyatti.algorithms.ctci.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class ZeroMatrix {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testZeroMatrix1() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7}
        };
        doZeroMatrixWithTwoArrays(matrix);
        int[][] result = new int[][]{
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7}
        };
        for (int row = 0; row < matrix.length; row++) Assert.assertArrayEquals(matrix[row], result[row]);
    }

    @Test
    public void testZeroMatrix2() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7}
        };
        doZeroMatrixWithoutAdditionalDS(matrix);
        int[][] result = new int[][]{
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7},
                new int[]{1, 2, 0, 4, 0, 6, 7}
        };
        for (int row = 0; row < matrix.length; row++) Assert.assertArrayEquals(matrix[row], result[row]);
    }

    public void doZeroMatrixWithTwoArrays(int[][] matrix) {
        boolean[] rowBool = new boolean[matrix.length];
        boolean[] colBool = new boolean[matrix[0].length];
        for (int row = 0; row < rowBool.length; row++) {
            for (int col = 0; col < colBool.length; col++) {
                if (matrix[row][col] == 0) {
                    rowBool[row] = true;
                    colBool[col] = true;
                }
            }
        }
        for (int row = 0; row < rowBool.length; row++) {
            for (int col = 0; col < colBool.length; col++) {
                if (rowBool[row] || colBool[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public void doZeroMatrixWithoutAdditionalDS(int[][] matrix) {
        boolean rowZero = false;
        boolean colZero = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == 0 && matrix[row][col] == 0) rowZero = true;
                else if (col == 0 && matrix[row][col] == 0) colZero = true;
                else if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == 0 && rowZero) matrix[row][col] = 0;
                else if (col == 0 && colZero) matrix[row][col] = 0;
                else if (matrix[0][col] == 0 || matrix[row][0] == 0) matrix[row][col] = 0;
            }
        }
    }
}

