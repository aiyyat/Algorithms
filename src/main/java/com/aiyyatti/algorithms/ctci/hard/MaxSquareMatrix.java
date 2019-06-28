package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import static java.lang.Math.min;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class MaxSquareMatrix {
    private static final Logger logger = getLogger(MaxSquareMatrix.class);
    ///////////////
    // TEST CASE //
    ///////////////
    static final int B = 0;
    static final int W = 1;

    @Test
    public void simpleTest() {
        int[][] square = new int[][]{
                new int[]{B, B, W, B, W, B, W, B},
                new int[]{W, W, B, B, B, B, B, B},
                new int[]{B, W, W, B, W, W, B, B},
                new int[]{W, B, W, B, W, W, B, B},
                new int[]{B, W, W, B, B, B, B, B},
                new int[]{B, W, W, B, B, B, B, B},
                new int[]{W, W, W, W, W, W, W, W},
                new int[]{W, W, W, W, W, W, W, W}
        };
        System.out.println(findMaxSqureMatrix(square));
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findMaxSqureMatrix(int[][] a) {
        int N = a.length;
        int max = 0;
        Cell[][] cell = new Cell[a.length][a.length];
        for (int row = N - 1; row >= 0; row--) {
            for (int col = N - 1; col >= 0; col--) {
                if (a[row][col] == W) cell[row][col] = new White();
                else cell[row][col] = new BlackBuilder(cell, row, col).build();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cell[i][j] instanceof Black) {
                    Black topLeft = (Black) cell[i][j];
                    int blacks = min(topLeft.rightBlack, topLeft.bottomBlack);
                    for (int k = 0; k < blacks; k++) {
                        Cell topRight = cell[i][k + j];
                        Cell bottomLeft = cell[k + i][j];
                        if (topRight.bottomBlack >= blacks && bottomLeft.rightBlack >= blacks) {
                            logger.debug("{} found square: "+blacks);
                            max = Math.max(blacks, max);
                        }
                    }
                }
            }
        }
        return max;
    }

    class Cell {
        int rightBlack = 0, bottomBlack = 0;
    }

    class White extends Cell {

    }

    class Black extends Cell {
        public Black() {
            this.rightBlack = 1;
            this.bottomBlack = 1;
        }
    }

    class BlackBuilder {
        Cell[][] matrix;
        int row = 0, column = 0;

        BlackBuilder(Cell[][] matrix, int row, int column) {
            this.matrix = matrix;
            this.row = row;
            this.column = column;
        }

        public Black build() {
            int N = matrix.length;
            Black black = new Black();
            if (row + 1 < N) black.bottomBlack += matrix[row + 1][column].bottomBlack;
            if (column + 1 < N) black.rightBlack += matrix[row][column + 1].rightBlack;
            return black;
        }
    }
}
