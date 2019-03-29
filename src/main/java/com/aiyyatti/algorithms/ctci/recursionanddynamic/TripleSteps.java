package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import org.junit.Test;

import java.util.Arrays;

public class TripleSteps {
    @Test
    public void simpleTest() {
        int K = 36;
        System.out.println(doTripleSteps(K));
        System.out.println(doRecursion(K));
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
        return doRecursion(K, memo);
    }

    /**
     * without memo: O(3^K)
     * with memo: O(K * S)
     *
     * @param K
     * @param memo
     * @return
     */
    public int doRecursion(int K, int[] memo) {
        if (K < 0) return 0;
        else if (K == 0) return 1;
        if (memo[K] != -1) return memo[K];
        return (memo[K] = doRecursion(K - 1, memo) + doRecursion(K - 2, memo) + doRecursion(K - 3, memo));
    }
}
