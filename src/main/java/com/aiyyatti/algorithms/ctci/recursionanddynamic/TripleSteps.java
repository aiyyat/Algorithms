package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class TripleSteps {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        int K = 36;
        TestCase.assertEquals(doTripleSteps(K), doRecursion(K));
    }

    int steps[] = new int[]{1, 2, 3};

    /**
     * O(K*S)
     *
     * @param K
     * @return
     */
    public int doTripleSteps(int K) {
        int[] memo = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 0; j < steps.length; j++) {
                int distance = i + steps[j];
                if (distance == K) {
                    memo[i]++;
                } else if (distance < K) {
                    memo[i] += memo[distance];
                }
            }
        }
        return memo[0];
    }

    public int doRecursion(int K) {
        int[] memo = new int[K + 1];
        Arrays.fill(memo, -1);
        return doRecursion(0, K, memo);
    }

    /**
     * without memo: O(3^steps)
     * with memo: O(steps * S)
     *
     * @param steps
     * @param memo
     * @return
     */
    public int doRecursion(int steps, int N, int[] memo) {
        if (steps > N) return 0;
        else if (steps == N) return 1;
        else if (memo[steps] == -1)
            memo[steps] = doRecursion(steps + 1, N, memo) + doRecursion(steps + 2, N, memo) + doRecursion(steps + 3, N, memo);
        return memo[steps];
    }
}
