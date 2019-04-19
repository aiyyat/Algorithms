package com.aiyyatti.algorithms.gfg.arrays;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * TimeComplexity O(2^n)
 * SpaceComplexity O(2^n)
 */
public class Fibanacci {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testFibanacii() {
        TestCase.assertEquals(13, doFibanacci(6));
    }

    public long doFibanacci(int N) {
        if (N == 0 || N == 1) return 1;
        return doFibanacci(N - 1) + doFibanacci(N - 2);
    }
}
