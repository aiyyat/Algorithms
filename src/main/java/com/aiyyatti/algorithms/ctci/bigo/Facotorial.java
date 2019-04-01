package com.aiyyatti.algorithms.ctci.bigo;

import junit.framework.TestCase;
import org.junit.Test;

public class Facotorial {
    @Test
    public void simpleTest() {
        TestCase.assertEquals(120, factorial(5));
    }

    /**
     * Time Complexity: O(n)
     * @param n
     * @return
     */
    public int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        else return n * factorial(n - 1);
    }
}
