package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import org.junit.Test;

import java.util.Arrays;

public class PaintFill {
    @Test
    public void simpleTest() {
        int X = 1;
        int O = 0;
        int[][] color = new int[][]{
                new int[]{O, X, X, X, X, O, X, O},
                new int[]{X, O, O, O, O, O, O, X},
                new int[]{X, O, X, O, O, O, O, X},
                new int[]{X, O, X, O, X, O, O, X},
                new int[]{O, X, X, O, O, X, O, O},
                new int[]{X, X, X, X, X, O, X, X}
        };
        doPaintFill(color, 2, 6, X);
        for (int i = 0; i < color.length; i++) {
            System.out.println(Arrays.toString(color[i]));
        }
    }

    public void doPaintFill(int[][] color, int row, int column, int toColor) {
        if (row > color[0].length || column > color.length || column < 0 || row < 0 || color[row][column] == toColor)
            return;
        color[row][column] = toColor;
        doPaintFill(color, row - 1, column, toColor);
        doPaintFill(color, row, column - 1, toColor);
        doPaintFill(color, row, column + 1, toColor);
        doPaintFill(color, row + 1, column, toColor);
    }
}
