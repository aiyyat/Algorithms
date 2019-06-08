package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class MaxSquareMatrix {
    boolean B = true;
    boolean W = false;
    boolean isDebug;

    @Test
    public void simpleTest() {
        boolean[][] matrix = new boolean[][]{
                new boolean[]{W, B, W},
                new boolean[]{B, B, W},
                new boolean[]{B, B, W}
        };
        assertEquals(2, doMaxSquareMatrix(matrix));
    }

    public int doMaxSquareMatrix(boolean[][] a) {
        int N = a.length;
        BlackMatrix[][] lookup = new BlackMatrix[N][N];
        int max = 0;
        for (int row = N - 1; row >= 0; row--) {
            for (int col = N - 1; col >= 0; col--) {
                if (!a[row][col]) lookup[row][col] = new BlackMatrix();
                else {
                    int below = (row + 1) > N - 1 ? 1 : lookup[row + 1][col].row() + 1;
                    int right = (col + 1) > N - 1 ? 1 : lookup[row][col + 1].column() + 1;
                    BlackMatrix blackMatrix = new BlackMatrix(below, right);
                    lookup[row][col] = blackMatrix;
                    max = Math.max(max, blackMatrix.getSquareMatrix());
                }
            }
        }
        if (isDebug) Arrays.stream(lookup).forEach(e -> System.out.println(Arrays.toString(e)));
        return max;
    }

    class BlackMatrix {
        private int row, column;

        public BlackMatrix() {

        }

        public BlackMatrix(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getSquareMatrix() {
            return Math.min(row, column);
        }

        public int row() {
            return row;
        }

        public int column() {
            return column;
        }

        @Override
        public String toString() {
            return String.format("(%s,%s)", row, column);
        }
    }
}