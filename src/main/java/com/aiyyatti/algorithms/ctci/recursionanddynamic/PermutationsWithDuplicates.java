package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import org.junit.Test;

/**
 * No Asserting for simple problems.
 */
public class PermutationsWithDuplicates {
    //////////////
    // TESTCASE //
    //////////////
    @Test
    public void simpleTest() {
        doPermutationsWithDuplicates("abc", 0);
    }

    public void doPermutationsWithDuplicates(String str, int index) {
        int N = str.length();
        if (index == N) System.out.println(str);
        for (int i = index; i < N; i++) {
            char ith = str.charAt(i);
            doPermutationsWithDuplicates(str.substring(0, index) + ith + str.substring(index, i) + str.substring(i + 1), index + 1);
        }
    }
}
