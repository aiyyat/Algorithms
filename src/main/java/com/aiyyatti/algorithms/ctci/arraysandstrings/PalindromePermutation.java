package com.aiyyatti.algorithms.ctci.arraysandstrings;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

/**
 * TODO: you can also use the bit operation if the strings are just a to z.
 */
public class PalindromePermutation {
    @Test
    public void simple1Test() {
        assertTrue(checkPalindromePermutationWithDS("Tact Coa"));
    }

    @Test
    public void simple2Test() {
        assertFalse(checkPalindromePermutationWithDS("Tact Coa a"));
    }

    @Test
    public void simple3Test() {
        assertTrue(checkPalindromePermutationWithBit("Tact Coa"));
    }

    @Test
    public void simple4Test() {
        assertFalse(checkPalindromePermutationWithBit("Tact Coa a"));
    }

    public boolean checkPalindromePermutationWithBit(String str) {
        return false;
    }

    public boolean checkPalindromePermutationWithDS(String str) {
        char[] a = str.toLowerCase().toCharArray();
        int[] count = new int[26];
        int N = a.length;
        int ne = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] >= 'a' && a[i] <= 'z') {
                int index = a[i] - 'a';
                count[index]++;
                if (count[index] % 2 != 0) ne++;
                else ne--;
            }
        }
        return ne == 1 || ne == 0;
    }
}
