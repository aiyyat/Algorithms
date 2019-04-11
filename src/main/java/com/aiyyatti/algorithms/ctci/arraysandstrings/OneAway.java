package com.aiyyatti.algorithms.ctci.arraysandstrings;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

import org.junit.Test;

public class OneAway {
    @Test
    public void simple1Test() {
        assertTrue(checkOneAway("pale", "ple"));
    }

    @Test
    public void simple2Test() {
        assertTrue(checkOneAway("pales", "pale"));
    }

    @Test
    public void simple3Test() {
        assertTrue(checkOneAway("pale", "bale"));
    }

    @Test
    public void simple4Test() {
        assertFalse(checkOneAway("pale", "bake"));
    }

    public boolean checkOneAway(String bigger, String smaller) {
        if (bigger.length() < smaller.length()) {
            String temp = smaller;
            smaller = bigger;
            bigger = temp;
        }
        int bN = bigger.length();
        int sN = smaller.length();
        int bI = 0;
        int sI = 0;
        boolean warned = false;
        while (bI < bN && sI < sN) {
            if (smaller.charAt(sI) == bigger.charAt(bI)) {
                sI++;
                bI++;
            } else if (!warned) {
                if (sN == bN) sI++;
                bI++;
                warned = true;
            } else return false;
        }
        return true;
    }
}
