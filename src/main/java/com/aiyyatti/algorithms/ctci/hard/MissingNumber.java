package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Brute Force:
 * 1) calculate the number of complete blocks from 0 for both numbers
 * 2) if the block count is odd then there is one extra block to be considered
 * e.g. if 1 complete block result must be 1*p below.
 * 3) if block count is even then one must be added while calculating
 * the left over since it start from 0 inclusive.
 * Resultant: if (completeBlocks % 2 == 1) return ((completeBlocks + 1) * pow / 2);
 * else return (completeBlocks * pow / 2) + ((start + 1) % pow);
 */
public class MissingNumber {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simple1Test() {
        int N = 7;
        int[] a = new int[N - 1];
        for (int i = 0; i < N; i++) {
            int offset = 0;
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    a[offset++] = j;
                }
            }
            TestCase.assertEquals(i, findMissingNumber(a, N));
            TestCase.assertEquals(i, findMissingNumberBruteForce(a, N));
        }
    }

    @Test
    public void simple2Test() {
        int[] a = new int[]{3, 4, 5, 7, 0, 2, 1};
        assertEquals(6, findMissingNumber(a, 7));
        assertEquals(6, findMissingNumberBruteForce(a, 7));
    }

    //////////
    // CTCI //
    //////////
    public int findMissingNumber(int[] a, int end) {
        int M = Integer.toBinaryString(end).length();
        // TODO Note the conversion.
        return doFindMissingNumber(Arrays.stream(a).boxed().collect(Collectors.toList()), M, 0);
    }

    public int doFindMissingNumber(List<Integer> a, int M, int current) {
        if (current == M) return 0;
        int N = a.size();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            Integer jth = a.get(j);
            if ((jth & 1 << (current)) == 0) zeros.add(jth);
            else ones.add(jth);
        }
        if (zeros.size() <= ones.size()) return (doFindMissingNumber(zeros, M, current + 1)) << 1;
        else return (doFindMissingNumber(ones, M, current + 1)) << 1 | 1;
    }

    /////////////////
    // BRUTE FORCE //
    /////////////////
    public int findMissingNumberBruteForce(int[] a, int end) {
        return findMissingNumberBruteForce(a, end, 0);
    }

    public int findMissingNumberBruteForce(int[] a, int end, int start) {
        int digits = 0;
        String output = "";
        while (Math.pow(2, digits) <= end) {
            int zeros = zerosInRange(end, digits) - zerosInRange(start - 1, digits);
            int ones = start - end - zeros;
            int actualZeros = 0;
            for (int i = 0; i < a.length; i++) {
                if ((a[i] & (1 << digits)) == 0) actualZeros++;
            }
            if (actualZeros - zeros != 0) output = 0 + output;
            else output = 1 + output;
            digits++;
        }
        return Integer.parseInt(output, 2);
    }

    public int zerosInRange(int start, int digits) {
        int pow = (int) Math.pow(2, digits);
        int completeBlocks = (start + 1) / pow;
        if (completeBlocks % 2 == 1) return ((completeBlocks + 1) * pow / 2);
        else return (completeBlocks * pow / 2) + ((start + 1) % pow);
    }
}