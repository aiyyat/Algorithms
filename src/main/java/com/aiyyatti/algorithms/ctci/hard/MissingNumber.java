package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO
 * Working but with a lot of code. Understand from CTCI how that works.
 * This approach:
 * 1) calculate the number of complete blocks from 0 for both numbers
 * 2) if the block count is odd then there is one extra block to be considered
 * e.g. if 1 complete block result must be 1*p below.
 * 3) if block count is even then one must be added while calculating
 * the left over since it start from 0 inclusive.
 * Resultant: if (completeBlocks % 2 == 1) return ((completeBlocks + 1) * pow / 2);
 * else return (completeBlocks * pow / 2) + ((start + 1) % pow);
 */
public class MissingNumber {
    @Test
    public void simpleTest() {
        int[] a = new int[]{3, 4, 5, 7, 8};
        assertEquals(6, findMissingNumber(a, 8, 3));
    }

    @Test
    public void testFindMissingNumber() {
        findMissingNumber(null, 11, 2);
    }

    @Test
    public void specifictestFindMissingNumber() {
        System.out.println(zerosInRange(5, 0));
    }

    public int findMissingNumber(int[] a, int end, int start) {
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