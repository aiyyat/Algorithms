package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 17.0
 * Todo:
 * Redo: No
 * Notes:
 */
public class WordDistance {
    private static final Logger logger = getLogger(WordDistance.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() throws Exception {
        int[] word1 = {10, 294, 2305, 9287, 1287, 4234, 1200, 1214, 765, 2341, 12123};
        int[] word2 = {7540, 2294, 2605, 9187, 1787, 4534, 1230, 1224, 793, 2351, 12623};
        assertThat(findMinWordDistance(word1, word2)).isEqualTo(10);
    }

    @Test
    public void simpleTest2() throws Exception {
        int[] word1 = {1, 10, 15, 20, 30};
        int[] word2 = {5, 7, 18, 25};
        assertThat(findMinWordDistance(word1, word2)).isEqualTo(2);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findMinWordDistance(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int aptr = 0, bptr = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            int diff = a[aptr] - b[bptr];
            min = Math.min(min, Math.abs(diff));
            logger.debug("{} -> {} = {}", a[aptr], b[bptr], min);
            if (diff < 0) aptr++;
            else bptr++;
            if (aptr >= a.length - 1 || bptr >= b.length - 1) return min;
        }
    }
}
