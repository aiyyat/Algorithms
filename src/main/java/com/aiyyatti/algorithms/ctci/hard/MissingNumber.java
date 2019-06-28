package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 30.1
 * Todo:
 * Redo: No
 * Note: tried to return the last element of the output arraylist assuming
 * that it will always have the value one, gives the mug impression.
 */
public class MissingNumber {
    private static final Logger logger = getLogger(MissingNumber.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple1() {
        int[] input = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9};
        assertThat(findMissingNumber(input, 9)).isEqualTo(4);
    }

    @Test
    public void testSimple2() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(findMissingNumber(input, 9)).isEqualTo(0);
    }

    @Test
    public void testSimple3() {
        int[] input = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(findMissingNumber(input, 9)).isEqualTo(9);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findMissingNumber(int[] input, int last) {
        List<Integer> a = new ArrayList<>();
        int N = input.length;
        String output = "";
        for (int i = 0; i < N; i++) a.add(input[i]);
        while (a.size() > 1) {
            int bitLen = bitSize(last);
            for (int i = 0; i < bitLen; i++) {
                List<Integer> zeros = new ArrayList<>();
                List<Integer> ones = new ArrayList<>();
                int zeroCount = 0;
                int oneCount = 0;
                for (int j = 0; j < a.size(); j++) {
                    Integer jth = a.get(j);
                    if (getBitAt(jth, i) == 1) {
                        oneCount++;
                        ones.add(jth);
                    } else {
                        zeroCount++;
                        zeros.add(jth);
                    }
                }
                int missing = 1;
                a = ones;

                if (zeroCount == oneCount || oneCount > zeroCount) {
                    missing = 0;
                    a = zeros;
                }
                output = missing + output;
                logger.debug("missing zero at {} hence reduced to {} and output is {}", i, a, output);
            }
        }
        return Integer.valueOf(output, 2);
    }

    public int getBitAt(int N, int position) {
        return (N & (1 << position)) >> position;
    }

    public int bitSize(int input) {
        return Integer.toBinaryString(input).length();
    }
}
