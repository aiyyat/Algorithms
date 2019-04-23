package com.aiyyatti.algorithms.courseera.algorithmspart2.week3;

import com.aiyyatti.algorithms.util.RandomInts;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 * Better for a lot of testcases, but not for all.
 */
public class RadixSort {
    /**
     * O(n):0.325
     * O(nlog(n)): 1.258
     */
    @Test
    public void simpleTest() {
        int range = 10;
        int[] a = dupsRandInts((int) Math.pow(10, 8), range);
        long then = Calendar.getInstance().getTimeInMillis();
        int[] actual = sort(a, range);
        System.out.println("O(n):" + (Calendar.getInstance().getTimeInMillis() - then) / 1000.0);
        then = Calendar.getInstance().getTimeInMillis();
        Arrays.sort(a);
        System.out.println("O(nlog(n)): " + (Calendar.getInstance().getTimeInMillis() - then) / 1000.0);
        Assert.assertArrayEquals(a, actual);
    }

    // allowable upto
    public int[] sort(int[] as, int range) {
        int[] index = new int[range + 1];
        for (int a : as) index[a + 1]++;
        for (int i = 1; i < index.length; i++) index[i] += index[i - 1];
        int[] sorted = new int[as.length];
        for (int a : as) sorted[index[a]++] = a;
        return sorted;
    }

    public static int[] dupsRandInts(int numberOfInts, int range) {
        int[] a = new int[numberOfInts];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) a[i] = rand.nextInt(range);
        return a;
    }
}
