package com.aiyyatti.algorithms.ctci.bigo;

import junit.framework.TestCase;
import org.junit.Test;

public class Prime {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        TestCase.assertTrue(isPrime(307));
    }

    @Test
    public void simpleTest2() {
        TestCase.assertFalse(isPrime(308));
    }

    @Test
    public void simpleTest3() {
        TestCase.assertTrue(isPrime(1223));
    }

    @Test
    public void simpleTest4() {
        TestCase.assertTrue(isPrime(2699));
    }

    /**
     * Time Complexity: O(sqrt(n))
     *
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i < n; i++) if (n % i == 0) return false;
        return true;
    }
}
