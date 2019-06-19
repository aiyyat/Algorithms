package com.aiyyatti.algorithms.ctci.hard;

import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.toObject;
import static org.hamcrest.Matchers.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 11.18
 * Todo:
 * Redo: No
 * Notes:
 */
public class RandomSet {
    private static final Logger logger = getLogger(RandomSet.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple1() {
        int[] data = new int[]{2, 3, 4, 5, 6, 7, 8};
        logger.info(Arrays.toString(doRandomSet(3, data)));
        IsArrayContainingInAnyOrder l;
        Integer[] actual1 = toObject(doRandomSet(3, data));
        Integer[] actual2 = toObject(doRandomSet(3, data));
        logger.info("actual 1 {} actual 2 {}",actual1, actual2);
        assertThat(actual1, hasItemInArray(isIn(toObject(data))));
        assertThat(actual1, not(actual2));
    }

    //////////////
    // SOLUTION //
    //////////////
    public int[] doRandomSet(int M, int[] a) {
        int m[] = new int[M];
        int N = a.length;
        for (int i = 0; i < M; i++) m[i] = a[i];
        for (int i = M; i < N; i++) {
            int rand = doRand(N);
            if (rand < M) m[rand] = a[i];
        }
        return m;
    }

    public int doRand(int N) {
        return new Random().nextInt(N);
    }
}
