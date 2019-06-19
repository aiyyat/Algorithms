package com.aiyyatti.algorithms.ctci.hard;

import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.toObject;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 11.25
 * Todo:
 * Redo: No
 * Notes:
 */
public class Shuffle {
    private static final Logger logger = getLogger(Shuffle.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
        int N = 52;
        Integer[] expected = new Integer[N];
        for (int i = 0; i < N; i++) expected[i] = i + 1;
        IsArrayContainingInAnyOrder l;
        Integer[] actual = toObject(doShuffle(N));
        assertThat(actual, arrayContainingInAnyOrder(expected));
    }

    //////////////
    // SOLUTION //
    //////////////
    public int[] doShuffle() {
        return doShuffle(52);
    }

    public int[] doShuffle(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = i + 1;
        for (int i = 0; i < N - 1; i++) {
            int rand = rand(i + 1, N);
            swap(a, i, rand);
        }
        return a;
    }

    private int rand(int from, int to) {
        return new Random().nextInt(to - from) + from;
    }

    private void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
