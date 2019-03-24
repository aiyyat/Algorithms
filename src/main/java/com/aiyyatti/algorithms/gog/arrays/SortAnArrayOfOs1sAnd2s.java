package com.aiyyatti.algorithms.gog.arrays;

import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
 */
public class SortAnArrayOfOs1sAnd2s {
    @Test
    public void testSimple1() {
        doSort(new int[]{0, 1, 2, 2, 1, 1, 1, 1, 0, 0, 0, 2, 1});
    }

    @Test
    public void testSimple2() {
        doSort(new int[]{1, 0, 1, 2, 1, 1, 0, 0, 1, 2, 1, 2, 1, 2, 1, 0, 0, 1, 1, 2, 2, 0, 0, 2, 2, 2, 1, 1, 1, 2, 0, 0, 0, 2, 0, 1, 1, 1, 1, 0, 0, 0, 2, 2, 1, 2, 2, 2, 0, 2, 1, 1, 2, 2, 0, 2, 2, 1, 1, 0, 0, 2, 0, 2, 2, 1, 0, 1, 2, 0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 1, 0, 0, 2, 2});
    }

    public static void main(String[] args) {
        new SortAnArrayOfOs1sAnd2s().doSort(System.in);
    }

    public void doSort(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] input = new int[N];
                for (int j = 0; j < N; j++) input[j] = scanner.nextInt();
                doSort(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception ei) {
            }
        }
    }

    public void doSort(int[] a) {
        int[] o = new int[a.length];
        int[] table = new int[3];
        for (int i = 0; i < a.length; i++) {
            table[a[i]]++;
        }
        int sumTillNow = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = sumTillNow; j < sumTillNow + table[i]; j++) o[j] = i;
            sumTillNow += table[i];
        }
        System.out.println(Arrays.stream(o).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
