package com.aiyyatti.algorithms.gfg.arrays;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
 * <p>
 * for (int i = N - 1; i - M + 1 >""="" 0; i--) {
 * Note: this is an example where there are 2 number which are N numbers apart. the two numbers should be
 * of least difference. for this sort the array first.
 */
public class ChocolateDistributionProblem {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        String input = "2\n" +
                "8\n" +
                "3 4 1 9 56 7 9 12\n" +
                "5\n" +
                "7\n" +
                "7 3 2 4 9 12 56\n" +
                "3";
        doChocolateDistribution(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testSimple2() {
        String input = "2\n" +
                "4\n" +
                "52 55 100 33 \n" +
                "1\n" +
                "15\n" +
                "88 57 44 92 28 66 60 37 33 52 38 29 76 8 75 \n" +
                "2";
        doChocolateDistribution(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        new ChocolateDistributionProblem().doChocolateDistribution(System.in);
    }

    public void doChocolateDistribution(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] a = new int[N];
                for (int j = 0; j < N; j++) {
                    a[j] = scanner.nextInt();
                }
                int M = scanner.nextInt();
                doChocolateDistribution(N, a, M);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doChocolateDistribution(int N, int[] a, int M) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = N - 1; i - M + 1 >= 0; i--) {
            min = Math.min(min, (a[i] == a[i - M + 1] ? a[i] : a[i] - a[i - M + 1]));
        }
        System.out.println(min);
    }
}
