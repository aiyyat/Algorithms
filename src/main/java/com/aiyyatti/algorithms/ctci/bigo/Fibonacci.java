package com.aiyyatti.algorithms.ctci.bigo;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Fibonacci {
    @Test
    public void testFibonacciSimple() {
        int a = 40;
        Instant then = Instant.now();
        TestCase.assertEquals(165580141, fib(a));
        System.out.println(ChronoUnit.MILLIS.between(then, Instant.now()));
        then = Instant.now();
        TestCase.assertEquals(165580141, fibWithMemo(a));
        System.out.println(ChronoUnit.MILLIS.between(then, Instant.now()));
    }

    public int fib(int a) {
        if (a <= 1) return 1;
        else return fib(a - 1) + fib(a - 2);
    }

    public int fibWithMemo(int a) {
        int[] memo = new int[a + 1];
        Arrays.fill(memo, -1);
        return fib(a, memo);
    }

    public int fib(int a, int memo[]) {
        if (memo[a] != -1) return memo[a];
        if (a == 0 || a == 1) memo[a] = 1;
        memo[a] = fib(a - 1) + fib(a - 2);
        return memo[a];
    }
}
