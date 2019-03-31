package com.aiyyatti.algorithms.gfg.arrays;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 */
public class KadanesAlgorithm {
    @Test
    public void testSimple() {
        String str = "2\n" +
                "5\n" +
                "1 2 3 -2 5\n" +
                "4\n" +
                "-1 -2 -3 -4";
        doKadane(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    public void testSimple2() {
        String str = "2\n" +
                "3\n" +
                "1 2 3\n" +
                "4\n" +
                "-1 -2 -3 -4";
        doKadane(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    public void testSimple3() {
        String str = "1\n" +
                "3\n" +
                "-2 5 -1";
        doKadane(new ByteArrayInputStream(str.getBytes()));
    }

    public static void main(String[] args) {
        new KadanesAlgorithm().doKadane(System.in);
    }

    public void doKadane(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] input = new int[N];
                for (int j = 0; j < N; j++) {
                    input[j] = scanner.nextInt();
                }
                doKadane(N, input);
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void doKadane(int N, int[] a) {
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < N; i++) {
            sum = Math.max(a[i], sum + a[i]);
            max = Math.max(max, sum);
        }
        System.out.println(Math.max(sum, max));
    }
}
