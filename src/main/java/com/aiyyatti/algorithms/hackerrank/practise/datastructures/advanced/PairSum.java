package com.aiyyatti.algorithms.hackerrank.practise.datastructures.advanced;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/pair-sums/problem
 */
public class PairSum {
    @Test
    public void simpleTest() {
        String str = "6\n" +
                "-3 7 -2 3 5 -2";
        System.out.println(doPairSum(new ByteArrayInputStream(str.getBytes())));
    }

    @Test
    public void simpleTest2() {
        String str = "10\n" +
                "5 7 -5 6 3 9 -8 2 -1 10\n";
        System.out.println(doPairSum(new ByteArrayInputStream(str.getBytes())));
    }

    @Test
    public void simpleTest3() {
        String str = "4\n" +
                "7 2 -1 2";
        System.out.println(doPairSum(new ByteArrayInputStream(str.getBytes())));
    }

    public static void main(String[] args) {
        doPairSum(System.in);
    }

    public static int doPairSum(InputStream bis) {
        try {
            Scanner scanner = new Scanner(bis);
            int N = scanner.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = scanner.nextInt();
            return doPairSum(a, N);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bis.close();
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    public static int doPairSum(int[] a, int N) {
        int[][] l = new int[N][N];
        int maxSumProduct = Integer.MIN_VALUE;
        for (int row = 0; row < N; row++) {
            for (int column = row; column >= 0; column--) {
                if (row == column) l[row][column] = 0;
                else if (row - column == 1) l[row][column] = a[row] * a[column];
                else {
                    l[row][column] = l[row][column + 1] + l[row - 1][column] - l[row - 1][column + 1] + (a[row] * a[column]);
                }
                maxSumProduct = Math.max(maxSumProduct, l[row][column]);
            }
        }
        return maxSumProduct;
    }
}
