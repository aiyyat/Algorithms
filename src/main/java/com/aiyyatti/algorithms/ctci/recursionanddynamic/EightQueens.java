package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import org.junit.Test;

import java.util.Arrays;

public class EightQueens {
    @Test
    public void testEightQueen() {
        fill(8);
    }

    public void fill(int N) {
        fill(new int[8], 0);
    }

    public void fill(int[] input, int column) {
        int[] a = input.clone();
        int N = a.length;
        if (column == N) print(a);
        else {
            for (int i = 0; i < N; i++) {
                if (check(a, i, column)) {
                    a[column] = i;
                    fill(a, column + 1);
                }
            }
        }
    }

    public boolean check(int[] a, int potentialDepth, int column) {
        for (int i = 0; i < column; i++) {
            if (potentialDepth == a[i]) return false;
            else if (Math.abs(potentialDepth - a[i]) == Math.abs(i - column)) {
                return false;
            }
        }
        return true;
    }

    public void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
