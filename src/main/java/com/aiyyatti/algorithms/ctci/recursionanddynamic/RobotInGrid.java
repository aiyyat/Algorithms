package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RobotInGrid {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleCannotReachTest() {
        int[][] matrix = new int[][]{
                new int[]{O, O, X, O, X, X},//1
                new int[]{O, O, X, O, X, O},//2
                new int[]{X, X, X, O, X, O},//3
                new int[]{O, O, O, O, X, O},//4
                new int[]{O, O, X, O, X, O},//5
                new int[]{O, O, O, O, O, O},//6
                new int[]{O, X, O, O, O, O},//7
                new int[]{X, O, O, X, O, O},//8
                new int[]{O, O, X, O, X, O},//9
                new int[]{O, O, O, X, O, O},//10
                new int[]{O, O, O, O, X, O},//11
                new int[]{O, X, O, O, O, O},//12
                new int[]{O, O, O, O, O, O}//13
        };
        assertFalse(doRobotInGrid(matrix));
    }

    @Test
    public void simpleCanReachTest() {
        int[][] matrix = new int[][]{
                new int[]{O, O, X, O, X, X},//1
                new int[]{O, O, O, O, X, O},//2
                new int[]{X, X, X, O, X, O},//3
                new int[]{O, O, O, O, X, O},//4
                new int[]{O, O, X, O, X, O},//5
                new int[]{O, O, O, O, X, O},//6
                new int[]{O, X, O, O, O, O},//7
                new int[]{X, O, O, X, O, O},//8
                new int[]{O, O, X, O, X, O},//9
                new int[]{O, O, O, X, O, O},//10
                new int[]{O, O, O, O, X, O},//11
                new int[]{O, X, O, O, O, O},//12
                new int[]{O, O, O, O, O, O}//13
        };
        assertTrue(doRobotInGrid(matrix));
    }

    int VISITED = 2;
    int X = 1;
    int O = 0;

    public boolean doRobotInGrid(int[][] matrix) {
        return doRobotInGrid(0, 0, matrix);
    }

    public boolean doRobotInGrid(int row, int column, int[][] matrix) {
        if (!withinLimits(matrix, row, column) || matrix[row][column] >= X) return false;
        matrix[row][column] = VISITED;
        if (metEnd(matrix, row, column)) return true;
        else if (doRobotInGrid(row, column + 1, matrix)) return true;
        else if (doRobotInGrid(row + 1, column, matrix)) return true;
        else return false;
    }

    private boolean metEnd(int[][] matrix, int row, int column) {
        return (row == matrix.length - 1) && (column == matrix[0].length - 1);
    }

    private boolean withinLimits(int[][] matrix, int row, int column) {
        if (row < matrix.length && column < matrix[0].length) return true;
        return false;
    }

    public void print(int[][] matrix) {
        System.out.println();
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println();
    }
}
