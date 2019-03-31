package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class RobotInGrid {
    @Test
    public void simpleCannotReachTest() {
        int[][] matrix = new int[][]{
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, STOP},//1
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, OPEN},//2
                new int[]{STOP, STOP, STOP, OPEN, STOP, OPEN},//3
                new int[]{OPEN, OPEN, OPEN, OPEN, STOP, OPEN},//4
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, OPEN},//5
                new int[]{OPEN, OPEN, OPEN, OPEN, OPEN, OPEN},//6
                new int[]{OPEN, STOP, OPEN, OPEN, OPEN, OPEN},//7
                new int[]{STOP, OPEN, OPEN, STOP, OPEN, OPEN},//8
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, OPEN},//9
                new int[]{OPEN, OPEN, OPEN, STOP, OPEN, OPEN},//10
                new int[]{OPEN, OPEN, OPEN, OPEN, STOP, OPEN},//11
                new int[]{OPEN, STOP, OPEN, OPEN, OPEN, OPEN},//12
                new int[]{OPEN, OPEN, OPEN, OPEN, OPEN, OPEN}//13
        };
        ArrayList<Point> path = new ArrayList<>();
        TestCase.assertFalse(doRobotInGrid(matrix.length - 1, matrix[0].length - 1, matrix, path));
    }

    @Test
    public void simpleCanReachTest() {
        int[][] matrix = new int[][]{
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, STOP},//1
                new int[]{OPEN, OPEN, OPEN, OPEN, STOP, OPEN},//2
                new int[]{STOP, STOP, STOP, OPEN, STOP, OPEN},//3
                new int[]{OPEN, OPEN, OPEN, OPEN, STOP, OPEN},//4
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, OPEN},//5
                new int[]{OPEN, OPEN, OPEN, OPEN, OPEN, OPEN},//6
                new int[]{OPEN, STOP, OPEN, OPEN, OPEN, OPEN},//7
                new int[]{STOP, OPEN, OPEN, STOP, OPEN, OPEN},//8
                new int[]{OPEN, OPEN, STOP, OPEN, STOP, OPEN},//9
                new int[]{OPEN, OPEN, OPEN, STOP, OPEN, OPEN},//10
                new int[]{OPEN, OPEN, OPEN, OPEN, STOP, OPEN},//11
                new int[]{OPEN, STOP, OPEN, OPEN, OPEN, OPEN},//12
                new int[]{OPEN, OPEN, OPEN, OPEN, OPEN, OPEN}//13
        };
        ArrayList<Point> path = new ArrayList<>();
        TestCase.assertTrue(doRobotInGrid(matrix.length - 1, matrix[0].length - 1, matrix, path));
    }

    int FAIL = 2;
    int STOP = 1;
    int OPEN = 0;

    public boolean doRobotInGrid(int row, int column, int[][] matrix, ArrayList<Point> path) {
        if (row == 0 && column == 0) return true; // Reached Home
        boolean top = (row > 0) && (matrix[row - 1][column] == OPEN);
        boolean left = (column > 0) && (matrix[row][column - 1] == OPEN);
        boolean goodCell = false;
        if (!top && !left) goodCell = false;
        else {
            if (top) goodCell |= doRobotInGrid(row - 1, column, matrix, path);
            if (left) goodCell |= doRobotInGrid(row, column - 1, matrix, path);
        }
        if (!goodCell) matrix[row][column] = FAIL;
        return goodCell;
    }

    class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void row(int row) {
            this.row = row;
        }

        public void column(int column) {
            this.column = column;
        }
    }
}
