package com.aiyyatti.algorithms.gfg.arrays;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/equilibrium-point/0
 */
public class EquilibriumPoint {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        String str = "2\n" +
                "1\n" +
                "1\n" +
                "5\n" +
                "1 3 5 2 2";
        findEquilibrium(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    public void testSimple2() {
        String str = "2\n" +
                "17\n" +
                "27 4 25 6 6 1 27 22 19 29 6 9 36 24 6 15 5 \n" +
                "8\n" +
                "43 34 2 8 17 5 11 8";
        findEquilibrium(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    public void testSimple3() {
        String str = "1\n" +
                "30\n" +
                "20 17 42 25 32 32 30 32 37 9 2 33 31 17 14 40 9 12 36 21 8 33 6 6 10 37 12 26 21 3";
        findEquilibrium(new ByteArrayInputStream(str.getBytes()));
    }

    public static void main(String[] args) {
        new EquilibriumPoint().findEquilibrium(System.in);
    }

    public void findEquilibrium(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] input = new int[N];
                for (int j = 0; j < N; j++) {
                    input[j] = scanner.nextInt();
                }
                findEquilibrium(N, input);
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * There is no need to use the aux array though. redo.
     *
     * @param N
     * @param a
     */
    public void findEquilibrium(int N, int[] a) {
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int[] aux = new int[N];
        aux[0] = a[0];
        for (int i = 1; i < N; i++) aux[i] = aux[i - 1] + a[i];
        for (int i = 1; i < N; i++) {
            if (aux[i - 1] == aux[N - 1] - aux[i]) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("-1");
    }
}
