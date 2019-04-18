package com.aiyyatti.algorithms.gfg;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
public class SortElementsByFrequencySet1 {
    @Test
    public void simpleTest() {
        int[] input = new int[]{2, 5, 2, 8, 5, 6, 8, 8};
        System.out.println(Arrays.toString(doSortElementsByFrequencySet1(input)));
    }

    public int[] doSortElementsByFrequencySet1(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        Integer[][] freq = new Integer[N][2];
        freq[0][0] = a[0];
        freq[0][1] = 1;
        for (int i = 1; i < N; i++) {
            freq[i] = new Integer[2];
            freq[i][0] = a[i];
            if (a[i] == freq[i - 1][0]) {
                freq[i][1] = freq[i - 1][1] + 1;
            } else {
                freq[i][1] = 1;
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            if (freq[i + 1][0] == freq[i][0]) freq[i][1] = freq[i + 1][1];
        }
        Arrays.sort(freq, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] i1, Integer[] i2) {
                return i1[1].compareTo(i2[1]) * -1;
            }
        });
        for (int i = 0; i < N; i++) {
            a[i] = freq[i][0];
        }
        return a;
    }
}
