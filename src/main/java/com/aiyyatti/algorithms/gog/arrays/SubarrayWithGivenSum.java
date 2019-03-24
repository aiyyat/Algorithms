package com.aiyyatti.algorithms.gog.arrays;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 */
public class SubarrayWithGivenSum {
    @Test
    public void simpleTest() {
        doSubArrayWithGivenSum(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15);
    }

    @Test
    public void simpleTest2() {
        doSubArrayWithGivenSum(5, new int[]{1, 2, 3, 7, 5}, 12);
    }

    public static void main(String[] args) {
        new SubarrayWithGivenSum().doSubArrayWithGivenSum(System.in);
    }

    public void doSubArrayWithGivenSum(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] a = new int[N];
                for (int j = 0; j < N; j++) a[j] = scanner.nextInt();
                int S = scanner.nextInt();
                doSubArrayWithGivenSum(N, a, S);
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void doSubArrayWithGivenSum(int N, int[] a, int S) {
        int[] aux = new int[N];
        aux[0] = a[0];
        for (int i = 1; i < N; i++) aux[i] = aux[i - 1] + a[i];
        for (int i = 0; i < N; i++) {
            int sumTillPrev = (i == 0) ? 0 : aux[i - 1];
            int toFind = S + sumTillPrev;
            for (int j = i; j < N; j++) {
                if (aux[j] == toFind) {
                    System.out.println(i + 1 + " " + (j + 1));
                    return;
                }
            }
        }
    }
}
