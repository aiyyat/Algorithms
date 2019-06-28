package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 40.2
 * Todo:
 * Redo: Yes
 * Notes: in-correct implementation with two potential majorities.
 */
public class MajorityElement {
    private static final Logger logger = getLogger(MajorityElement.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testMajority() {
        assertThat(findMajorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5})).isEqualTo(5);
    }

    @Test
    public void testMajority2() {
        assertThat(findMajorityElement(new int[]{1, 2, 9, 5, 9, 5, 5, 5})).isEqualTo(-1);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findMajorityElement(int[] a) {
        return findMajorityElement(a, 0);
    }

    public int findMajorityElement(int[] a, int at) {
        int match = 1, total = 1, N = a.length;
        if (at >= N) return -1;
        logger.debug(Arrays.toString(copyOfRange(a, at, N - 1)));
        int element = a[at];
        for (int i = at + 1; i < N; i++) {
            if (element == a[i]) match++;
            total++;
            logger.debug("element{} has match{} and total{}", element, match, total);
            if (match <= (total / 2.0)) return findMajorityElement(a, i + 1);
        }
        // check if not equal to half
        match = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] == element) match++;
            if (match > N / 2) return element;
        }
        return -1;
    }
}
