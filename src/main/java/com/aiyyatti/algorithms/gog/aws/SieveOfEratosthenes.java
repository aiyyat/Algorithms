package com.aiyyatti.algorithms.gog.aws;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;

/**
 * The sieve of Eratosthenes algorithm generates all the primes up to a given limit.
 * This is a common and fast algorithm used to generate a list of primes up to a given limit.
 * It works by making a list from 1 to N, and then iterating through the list
 * and progressively removing non-prime, composite numbers until only primes are left in a list.
 */
public class SieveOfEratosthenes {
    @Test
    public void testSimple() {
        TestCase.assertEquals(
                "[1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]",
                doSieveOfEratpsthenes(100).toString());
    }

    public LinkedList<Integer> doSieveOfEratpsthenes(int N) {
        LinkedList<Integer> output = new LinkedList<>();
        boolean[] list = new boolean[N + 1];
        for (int i = 0; i < N; i++) list[i] = true;
        for (int a = 2; a < N; a++) {
            if (list[a])
                for (int b = a + a; b < N; b += a)
                    list[b] = false;
        }
        for (int i = 1; i < N; i++) {
            if (list[i]) output.add(i);
        }
        return output;
    }
}
