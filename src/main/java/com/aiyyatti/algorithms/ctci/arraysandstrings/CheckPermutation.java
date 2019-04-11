package com.aiyyatti.algorithms.ctci.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * TODO: you can sort and check with two indices.
 */
public class CheckPermutation {
    @Test
    public void test() {
        assertTrue(checkPermutation("category", "tea"));
    }

    @Test
    public void test2() {
        assertFalse(checkPermutation("category", "teaz"));
    }

    @Test
    public void test3() {
        assertTrue(checkPermutation("a", "a"));
    }

    public boolean checkPermutation(String bigger, String smaller) {
        if (smaller.length() > bigger.length()) {
            String temp = bigger;
            bigger = smaller;
            smaller = temp;
        }
        // TODO: this can be used with 256 ascii characterset also
        int[] count = new int[26];
        for (int i = 0; i < bigger.length(); i++) {
            count[bigger.charAt(i) - 'a']++;
        }
        for (int i = 0; i < smaller.length(); i++) {
            int index = smaller.charAt(i) - 'a';
            count[index]--;
            if (count[index] < 0) return false;
        }
        return true;
    }
}
