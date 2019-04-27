package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RecursiveMultiply {
    ///////////////
    // TESTCASES //
    ///////////////
    @Test
    public void testMx0() {
        assertEquals(0, doRecursiveMultiply(3, 0));
    }

    @Test
    public void testMx1() {
        assertEquals(3, doRecursiveMultiply(3, 1));
    }

    @Test
    public void testMxN() {
        assertEquals(363, doRecursiveMultiply(33, 11));
    }

    public int doRecursiveMultiply(int a, int b) {
        return a > b ? recursiveMultiply(b, a) : recursiveMultiply(a, b);
    }

    //////////////
    // SOLUTION //
    //////////////
    private int recursiveMultiply(int smaller, int larger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return larger;
        int result = recursiveMultiply(smaller >> 1, larger);
        return result + result + (smaller % 2 == 0 ? 0 : larger);
    }
}